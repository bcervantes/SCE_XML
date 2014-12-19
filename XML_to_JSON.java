import org.json.JSONObject;
import org.json.XML;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/* WORKS WITH ANY SCE XML FILE */

public class XML_to_JSON {

    public static void main(String args[]) {

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            final StringBuilder builder = new StringBuilder();
            //title belongs to Parent: Pole = sce:Pole, Conductor = sce:Conductor, etc.
            final String title = "sce:Pole";

            DefaultHandler handler = new DefaultHandler()
            {

                /*
                To only call upon the elements that are referenced
                 */
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
                boolean symbolRef = false;
                boolean orientation = false;
                boolean substationMRID = false;
                boolean owner = false;
                boolean ownerType = false;
                boolean ratedVoltage = false;
                boolean pos = false;
                boolean strucRefMRID = false;
                boolean structureID = false;
                boolean serviceType = false;
                boolean bundleType = false;
                boolean circuitName = false;
                boolean circuitSection = false;
                boolean material = false;
                boolean size = false;
                boolean quantity = false;
                boolean phase = false;
                boolean posList = false;
                boolean no_of_wires = false;
                boolean commIndicator = false;

                public void startElement(String uri, String localName,String qName,
                                         Attributes attributes) throws SAXException {
                    /*
                    Ignore unneeded Header/Parent elements
                     */

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

                    if (qName.equalsIgnoreCase("sce:symbolRef")) {
                        symbolRef = true;
                    }

                    if (qName.equalsIgnoreCase("sce:orientation")) {
                        orientation = true;
                    }

                    if (qName.equalsIgnoreCase("sce:substationMRID")) {
                        substationMRID = true;
                    }

                    if (qName.equalsIgnoreCase("sce:owner")) {
                        owner = true;
                    }

                    if (qName.equalsIgnoreCase("sce:ownerType")) {
                        ownerType = true;
                    }

                    if (qName.equalsIgnoreCase("sce:ratedVoltage")) {
                        ratedVoltage = true;
                    }

                    if (qName.equalsIgnoreCase("gml:pos")) {
                        pos = true;
                    }

                    if (qName.equalsIgnoreCase("sce:bundleType")) {
                        bundleType = true;
                    }

                    if (qName.equalsIgnoreCase("sce:circuitName")) {
                        circuitName = true;
                    }

                    if (qName.equalsIgnoreCase("sce:circuitSection")) {
                        circuitSection = true;
                    }

                    if (qName.equalsIgnoreCase("sce:material")) {
                        material = true;
                    }

                    if (qName.equalsIgnoreCase("sce:size")) {
                        size = true;
                    }

                    if (qName.equalsIgnoreCase("sce:quantity")) {
                        quantity = true;
                    }

                    if (qName.equalsIgnoreCase("sce:phase")) {
                        phase = true;
                    }

                    if (qName.equalsIgnoreCase("gml:posList")) {
                        posList = true;
                    }

                    if (qName.equalsIgnoreCase("sce:no_of_wires")) {
                        no_of_wires = true;
                    }

                    if (qName.equalsIgnoreCase("sce:commIndicator")) {
                        commIndicator = true;
                    }

                    if (qName.equalsIgnoreCase("sce:structureID")) {
                        structureID = true;
                    }

                    if (qName.equalsIgnoreCase("sce:strucRefMRID")) {
                        strucRefMRID = true;
                    }

                    if (qName.equalsIgnoreCase("sce:serviceType")) {
                        serviceType = true;
                    }

                }

                public void endElement(String uri, String localName, String qName) throws SAXException {

                    /*
                    Ignore Header
                     */
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
                        all = "";
                    }

                    if (symbolRef) {
                        builder.append(all);
                        symbolRef = false;
                        all = "";
                    }

                    if (orientation) {
                        builder.append(all);
                        orientation = false;
                        all = "";
                    }

                    if (substationMRID) {
                        builder.append(all);
                        substationMRID = false;
                        all = "";
                    }

                    if (owner) {
                        builder.append(all);
                        owner = false;
                        all = "";
                    }

                    if (ownerType) {
                        builder.append(all);
                        ownerType = false;
                        all = "";
                    }

                    if (ratedVoltage) {
                        builder.append(all);
                        ratedVoltage = false;
                        all = "";
                    }

                    if (pos) {
                        builder.append(all);
                        pos = false;
                        all = "";
                    }

                    if (bundleType) {
                        builder.append(all);
                        bundleType = false;
                        all = "";
                    }

                    if (circuitName) {
                        builder.append(all);
                        circuitName = false;
                        all = "";
                    }

                    if (circuitSection) {
                        builder.append(all);
                        circuitSection = false;
                        all = "";
                    }

                    if (material) {
                        builder.append(all);
                        material = false;
                        all = "";
                    }

                    if (size) {
                        builder.append(all);
                        size = false;
                        all = "";
                    }

                    if (quantity) {
                        builder.append(all);
                        quantity = false;
                        all = "";
                    }

                    if (phase) {
                        builder.append(all);
                        phase = false;
                        all = "";
                    }

                    if (posList) {
                        builder.append(all);
                        posList = false;
                        all = "";
                    }

                    if (no_of_wires) {
                        builder.append(all);
                        no_of_wires = false;
                        all = "";
                    }

                    if (commIndicator) {
                        builder.append(all);
                        commIndicator = false;
                        all = "";
                    }

                    if (serviceType) {
                        builder.append(all);
                        serviceType = false;
                        all = "";
                    }

                    if (structureID) {
                        builder.append(all);
                        structureID = false;
                        all = "";
                    }

                    if (strucRefMRID) {
                        builder.append(all);
                        strucRefMRID = false;
                        all = "";

                    }


                }

            };

            /*
            File located on my local machine
             */
            saxParser.parse("C:\\Users\\bcervantes\\Desktop\\30\\District_30_Pole.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}