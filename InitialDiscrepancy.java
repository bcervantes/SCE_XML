import com.mongodb.*;

import java.util.ArrayList;
import java.util.List;

/* POLE FILE WITH POLE PARENT */

public class InitialDiscrepancy {

    public static void main(String args[]) {

        try {

            Mongo mongo = new Mongo("localhost", 27017);
            DB db = mongo.getDB("District30");
            DBCollection collection = db.getCollection("Poles");
            String title = "sce:Pole";
            int i = 0;

            System.out.println("Known issues\n**************************");

            i = 0;
            BasicDBObject whereQuery = new BasicDBObject();
            BasicDBObject existsQuery = new BasicDBObject();
            existsQuery.put("$exists",false);
            whereQuery.put("Pole.Location.highWindFlag", existsQuery);
            BasicDBObject whereQuery2 = new BasicDBObject();
            whereQuery2.put("Pole.grandFatherFlag", existsQuery);


            BasicDBObject andQuery = new BasicDBObject();
            List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
            obj.add(new BasicDBObject("Pole.name",""));
            obj.add(new BasicDBObject("Pole.Location.PositionPoints.xPosition",""));
            obj.add(new BasicDBObject("Pole.Location.PositionPoints.yPosition", ""));
            obj.add(new BasicDBObject("Pole.windRating.currentRating", ""));
            obj.add(whereQuery);
            obj.add(whereQuery2);
            andQuery.put("$or", obj);
            DBCursor cursor = collection.find(andQuery);
            i = 0;
            while (cursor.hasNext()){
                cursor.next();
                ++i;
            }
            System.out.println("Partial Count: " + i);

            List<String> li = new ArrayList<String>();
            li.add("Pole.name");
            li.add("Pole.windRating.currentRating");
            li.add("Pole.windRating.inServiceRating");
            li.add("Pole.rSMVal");
            for ( int x = 0; x < li.size(); ++x){
                i = 0;
                whereQuery = new BasicDBObject();
                whereQuery.put(li.get(x),"");
                cursor = collection.find(whereQuery);
                while (cursor.hasNext()){
                    cursor.next();
                    ++i;
                }
                System.out.println("Missing " + li.get(x) + ": " + i);
            }

            li = new ArrayList<String>();
            li.add("Pole.Location.highFireFlag");
            li.add("Pole.Location.highWindFlag");
            li.add("Pole.grandFatherFlag");
            for (int x=0;x<li.size();++x){
                i = 0;
                whereQuery = new BasicDBObject();
                whereQuery.put(li.get(x), existsQuery);
                cursor = collection.find(whereQuery);
                while (cursor.hasNext()){
                    cursor.next();
                    ++i;
                }
                System.out.println("Missing " + li.get(x) + ": " + i);
            }

            andQuery = new BasicDBObject();
            obj = new ArrayList<BasicDBObject>();
            obj.add(new BasicDBObject("Pole.Location.PositionPoints.xPosition",""));
            obj.add(new BasicDBObject("Pole.Location.PositionPoints.yPosition", ""));
            andQuery.put("$or", obj);
            cursor = collection.find(andQuery);
            i = 0;
            while (cursor.hasNext()){
                cursor.next();
                ++i;
            }
            System.out.println("Missing Lat/Long: " + i);

            System.out.println("\nDataset summary\n**********************");

            i = 0;
            cursor = collection.find();
            while (cursor.hasNext()){
                cursor.next();
                ++i;
            }
            System.out.println("Total: " + i);

            i = 0;
            whereQuery = new BasicDBObject();
            whereQuery.put("Pole.status.value","EXCLUDED");
            cursor = collection.find(whereQuery);
            while (cursor.hasNext()){
                cursor.next();
                ++i;
            }
            System.out.println("Excluded: " + i);

            i = 0;
            whereQuery = new BasicDBObject();
            whereQuery.put("Pole.status.value","ASSIGNED");
            cursor = collection.find(whereQuery);
            while (cursor.hasNext()){
                cursor.next();
                ++i;
            }
            System.out.println("Assigned: " + i);

            i = 0;
            whereQuery = new BasicDBObject();
            whereQuery.put("Pole.status.value","ONHOLD");
            cursor = collection.find(whereQuery);
            while (cursor.hasNext()){
                cursor.next();
                ++i;
            }
            System.out.println("On-Hold: " + i);

            i = 0;
            whereQuery = new BasicDBObject();
            whereQuery.put("Pole.status.value","CANCELLED");
            cursor = collection.find(whereQuery);
            while (cursor.hasNext()){
                cursor.next();
                ++i;
            }
            System.out.println("Cancelled: " + i);

            i = 0;
            whereQuery = new BasicDBObject();
            whereQuery.put("Pole.Location.highFireFlag",true);
            cursor = collection.find(whereQuery);
            while (cursor.hasNext()){
                cursor.next();
                ++i;
            }
            System.out.println("HF: " + i);

            i = 0;
            whereQuery = new BasicDBObject();
            whereQuery.put("Pole.Location.highWindFlag",true);
            cursor = collection.find(whereQuery);
            while (cursor.hasNext()){
                cursor.next();
                ++i;
            }
            System.out.println("HW: " + i);

            andQuery = new BasicDBObject();
            obj = new ArrayList<BasicDBObject>();
            obj.add(new BasicDBObject("Pole.Location.highFireFlag", true));
            obj.add(new BasicDBObject("Pole.Location.highWindFlag", true));
            andQuery.put("$and", obj);
            cursor = collection.find(andQuery);
            i = 0;
            while (cursor.hasNext()){
                cursor.next();
                ++i;
            }
            System.out.println("HW+HF: " + i);

            i = 0;
            whereQuery = new BasicDBObject();
            whereQuery.put("Pole.grandFatherFlag",true);
            cursor = collection.find(whereQuery);
            while (cursor.hasNext()){
                cursor.next();
                ++i;
            }
            System.out.println("GF: " + i);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}