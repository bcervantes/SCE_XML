import org.json.JSONObject;
import org.json.XML;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/* POLE FILE WITH POLE PARENT */

public class pole {

    public static void main(String args[]) {

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            final StringBuilder builder = new StringBuilder();
            final String title = "sce:Pole";
            int i = 0;

            DefaultHandler handler = new DefaultHandler()
            {

                boolean mRID = false;
                boolean aliasName = false;
                boolean name = false;
                boolean grandFather = false;
                boolean pType = false;
                boolean value = false;
                boolean baseKind = false;
                boolean classification = false;
                boolean unit = false;
                boolean speciesT = false;
                boolean rSMVal = false;
                boolean specialProj = false;
                boolean cRating = false;
                boolean iRating = false;
                boolean highWind = false;
                boolean highFire = false;
                boolean srsName = false;
                boolean xPos = false;
                boolean yPos = false;
                boolean desc = false;
                boolean street = false;
                boolean city = false;
                boolean mapRef = false;
                boolean installDate = false;

                public void startElement(String uri, String localName,String qName,
                                         Attributes attributes) throws SAXException {

                    if(qName.equalsIgnoreCase("sce:PLPExtract") | (qName.equalsIgnoreCase("sce:Payload"))
                            | (qName.equalsIgnoreCase("sce:Header"))) {
                        return;
                    }

                    builder.append("<").append(qName).append(">");

                    if (qName.equalsIgnoreCase("sce:mRID")) {
                        mRID = true;
                    }

                    if (qName.equalsIgnoreCase("sce:aliasName")) {
                        aliasName = true;
                    }

                    if (qName.equalsIgnoreCase("sce:name")) {
                        name = true;
                    }

                    if (qName.equalsIgnoreCase("sce:grandFatherFlag")) {
                        grandFather = true;
                    }

                    if (qName.equalsIgnoreCase("sce:type")) {
                        pType = true;
                    }

                    if (qName.equalsIgnoreCase("sce:value")) {
                        value = true;
                    }

                    if (qName.equalsIgnoreCase("sce:baseKind")) {
                        baseKind = true;
                    }

                    if (qName.equalsIgnoreCase("sce:classification")) {
                        classification = true;
                    }

                    if (qName.equalsIgnoreCase("sce:unit")) {
                        unit = true;
                    }

                    if (qName.equalsIgnoreCase("sce:speciesType")) {
                        speciesT = true;
                    }

                    if (qName.equalsIgnoreCase("sce:rSMVal")) {
                        rSMVal = true;
                    }

                    if (qName.equalsIgnoreCase("sce:specialProjectName")) {
                        specialProj = true;
                    }

                    if (qName.equalsIgnoreCase("sce:currentRating")) {
                        cRating = true;
                    }

                    if (qName.equalsIgnoreCase("sce:inServiceRating")) {
                        iRating = true;
                    }

                    if (qName.equalsIgnoreCase("sce:highWindFlag")) {
                        highWind = true;
                    }

                    if (qName.equalsIgnoreCase("sce:highFireFlag")) {
                        highFire = true;
                    }

                    if (qName.equalsIgnoreCase("sce:srsName")) {
                        srsName = true;
                    }

                    if (qName.equalsIgnoreCase("sce:xPosition")) {
                        xPos = true;
                    }

                    if (qName.equalsIgnoreCase("sce:yPosition")) {
                        yPos = true;
                    }

                    if (qName.equalsIgnoreCase("sce:description")) {
                        desc = true;
                    }

                    if (qName.equalsIgnoreCase("sce:street")) {
                        street = true;
                    }

                    if (qName.equalsIgnoreCase("sce:city")) {
                        city = true;
                    }

                    if (qName.equalsIgnoreCase("sce:mapRefNumber")) {
                        mapRef = true;
                    }

                    if (qName.equalsIgnoreCase("sce:installationDate")) {
                        installDate = true;
                    }

                }

                public void endElement(String uri, String localName, String qName) throws SAXException {



                    if (qName.equalsIgnoreCase("sce:Header")){

                        builder.setLength(0);
                        return;
                    }

                    builder.append("</").append(qName).append(">");

                    if (qName.equalsIgnoreCase(title)) {

                        String xml = builder.toString();
                        try {
                            JSONObject jObj = XML.toJSONObject(xml);
                            System.out.println(jObj);
                        } catch (org.json.JSONException e) {
                            e.printStackTrace();
                        }
                        builder.setLength(0);

                    }

                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    String all = new String(ch, start, length);
                    all = all.trim();

                    if (mRID) {
                        builder.append(all);
                        mRID = false;
                        all = "";
                    }

                    if (aliasName) {
                        builder.append(all);
                        aliasName = false;
                        all = "";
                    }

                    if (name) {
                        builder.append(all);
                        name = false;
                        all = "";

                    }

                    if (grandFather) {
                        builder.append(all);
                        grandFather = false;
                        all = "";
                    }

                    if (pType) {
                        builder.append(all);
                        pType = false;
                        all = "";
                    }

                    if (value) {
                        builder.append(all);
                        value = false;
                        all = "";
                    }

                    if (baseKind) {
                        builder.append(all);
                        baseKind = false;
                        all = "";
                    }

                    if (classification) {
                        builder.append(all);
                        classification = false;
                        all = "";
                    }

                    if (unit) {
                        builder.append(all);
                        unit = false;
                        all = "";
                    }

                    if (speciesT) {
                        builder.append(all);
                        speciesT = false;
                        all = "";
                    }

                    if (rSMVal) {
                        builder.append(all);
                        rSMVal = false;
                        all = "";
                    }

                    if (specialProj) {
                        builder.append(all);
                        specialProj = false;
                        all = "";
                    }

                    if (cRating) {
                        builder.append(all);
                        cRating = false;
                        all = "";
                    }

                    if (iRating) {
                        builder.append(all);
                        iRating = false;
                        all = "";
                    }

                    if (highWind) {
                        builder.append(all);
                        highWind = false;
                        all = "";
                    }

                    if (highFire) {

                        builder.append(all);
                        highFire = false;
                        all = "";
                    }

                    if (srsName) {
                        builder.append(all);
                        srsName = false;
                        all = "";
                    }

                    if (xPos) {
                        builder.append(all);
                        xPos = false;
                        all = "";
                    }

                    if (yPos) {
                        builder.append(all);
                        yPos = false;
                        all = "";
                    }

                    if (desc) {
                        builder.append(all);
                        desc = false;
                        all = "";
                    }

                    if (street) {
                        builder.append(all);
                        street = false;
                        all = "";
                    }

                    if (city) {
                        builder.append(all);
                        city = false;
                        all = "";
                    }

                    if (mapRef) {
                        builder.append(all);
                        mapRef = false;
                        all = "";
                    }

                    if (installDate) {
                        builder.append(all);
                        installDate = false;
                    }

                }

            };

            saxParser.parse("C:\\Users\\bcervantes\\Desktop\\30\\District_30_Pole.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}