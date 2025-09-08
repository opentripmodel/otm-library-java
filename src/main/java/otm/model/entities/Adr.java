package otm.model.entities;

import java.util.List;
import java.util.Optional;

/**
 * Information about the potentially dangerous properties of these goods.
 */
public class Adr {
    /**
     * A UN number (United Nations number) is a four-digit number that identifies hazardous materials, and articles (such as explosives, flammable liquids, oxidizers, toxic liquids, etc.) in the framework of international transport. The list of UN numbers can be found in the official specification.
     */
    private String unNumber;

    /**
     * Marks shall be in an official language as the country of origin and also, if that language is not English, French or German, in English, French or German, unless agreements, if any, concluded between the countries concerned in transport operations provide otherwise.
     */
    private String language;

    /**
     * Contains in upper case characters, the name of the substance or article if the substance or article has been assigned its own specific UN number, or otherwise the proper shipping name shall be used.
     */
    private String description;

    /**
     * The technical name which shall supplement the proper shipping name shall be the ISO common name. A recognized chemical name, if relevant a biological name, or other name currently used in scientific and technical handbooks, journals and texts. (see 3.1.2.8.1.1 in <a href="https://unece.org/sites/default/files/2021-01/ADR2021_Vol1e_0.pdf">ADR2021_Vol1e_0.pdf</a>)
     */
    private String technicalName;

    /**
     * Indicator to be used in case commodity is classified as waste
     */
    private boolean waste;

    /**
     * Indicator to be used to label waste as environmentally hazardous.
     */
    private boolean environmentallyHazardous;

    /**
     * <p>
     *     Changed from "class" because it's a reserved keyword in Java
     * </p>
     * <p>
     *     Number of the class, whose heading covers the dangerous substance or article. 2.1.1.1 The classes of dangerous goods according to ADR are the following:
     * </p>
     * <ul>
     *     <li>Class 1 Explosive substances and articles</li>
     *     <li>Class 2 Gases</li>
     *     <li>Class 3 Flammable liquids</li>
     *     <li>Class 4.1 Flammable solids, self-reactive substances, polymerizing substances and solid desensitized explosives</li>
     *     <li>Class 4.2 Substances liable to spontaneous combustion</li>
     *     <li>Class 4.3 Substances which, in contact with water, emit flammable gases</li>
     *     <li>Class 5.1 Oxidizing substances</li>
     *     <li>Class 5.2 Organic peroxides</li>
     *     <li>Class 6.1 Toxic substances</li>
     *     <li>Class 6.2 Infectious substances</li>
     *     <li>Class 7 Radioactive material</li>
     *     <li>Class 8 Corrosive substances</li>
     *     <li>Class 9 Miscellaneous dangerous substances and articles</li>
     * </ul>
     */
    private String clazz; //

    /**
     * The classification code of the dangerous substance or article. The code consists out of a division number and compatibility group letter depending on the class
     */
    private String classificationCode;

    /**
     * Packing Group means a group of which, for packing purposes, certain substances may be assigned in accordance with their degree of danger. Packing group values: I, II and II
     */
    private String packagingGroup;

    /**
     * The model number(s) of the labels/placards (see 5.2.2.2 and 5.3.1.7 <a href="https://unece.org/sites/default/files/2021-01/ADR2021_Vol1e_0.pdf">ADR2021_Vol1e_0.pdf</a> that have to be affixed to packages, containers, tank containers, portable tanks, MEGC’s and veh
     */
    private List<String> dangerLabels;

    /**
     *
     */
    private String dangerNumber;

    /**
     * Code to indicate tunnel category where restrictions apply to the passage of vehicles carrying dangerous goods. Categories A.B.C.D. and E as defined in 1.9.5.2.2. <a href="https://unece.org/sites/default/files/2021-01/ADR2021_Vol1e_0.pdf">ADR2021_Vol1e_0.pdf</a>
     */
    private String tunnelCode;

    /**
     * Special provisions related to this entity or action.
     */
    private String specialProvisions;

    /**
     * Points associated with this entity, if applicable.
     * Represented as an Optional to handle the nullable nature of System.Int32.
     */
    private Optional<Integer> points;

    /**
     * The transport category for this entity, if applicable.
     * Represented as an Optional to handle the nullable nature of TransportCategory.
     */
    private Optional<TransportCategory> transportCategory;

    // Getters and setters

    /**
     * Get
     * @return
     */
    public String getUnNumber() {
        return unNumber;
    }

    public void setUnNumber(String unNumber) {
        this.unNumber = unNumber;
    }

    /**
     * Get
     * @return
     */
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Get
     * @return
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get
     * @return
     */
    public String getTechnicalName() {
        return technicalName;
    }

    public void setTechnicalName(String technicalName) {
        this.technicalName = technicalName;
    }

    public boolean isWaste() {
        return waste;
    }

    public void setWaste(boolean waste) {
        this.waste = waste;
    }

    public boolean isEnvironmentallyHazardous() {
        return environmentallyHazardous;
    }

    public void setEnvironmentallyHazardous(boolean environmentallyHazardous) {
        this.environmentallyHazardous = environmentallyHazardous;
    }

    /**
     * Get the number of the class, whose heading covers the dangerous substance or article. 2.1.1.1 The classes of dangerous goods, according to ADR
     * @return Number of the class, whose heading covers the dangerous substance or article. 2.1.1.1 The classes of dangerous goods, according to ADR
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Set the number of the class, whose heading covers the dangerous substance or article. 2.1.1.1 The classes of dangerous goods, according to ADR
     * @param clazz The number of the class, whose heading covers the dangerous substance or article. 2.1.1.1 The classes of dangerous goods, according to ADR
     */
    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    /**
     * Get the classification code of the dangerous substance or article. The code consists out of a division number and compatibility group letter depending on the class
     * @return The classification code of the dangerous substance or article. The code consists out of a division number and compatibility group letter depending on the class
     */
    public String getClassificationCode() {
        return classificationCode;
    }

    /**
     * Set the classification code of the dangerous substance or article. The code consists out of a division number and compatibility group letter depending on the class
     * @param classificationCode The classification code of the dangerous substance or article. The code consists out of a division number and compatibility group letter depending on the class
     */
    public void setClassificationCode(String classificationCode) {
        this.classificationCode = classificationCode;
    }

    /**
     * Get the Packing Group means a group of which, for packing purposes, certain substances may be assigned in accordance with their degree of danger. Packing group values: I, II and II
     * @return Packing Group means a group of which, for packing purposes, certain substances may be assigned in accordance with their degree of danger. Packing group values: I, II and II
     */
    public String getPackagingGroup() {
        return packagingGroup;
    }

    /**
     * Set the Packing Group means a group of which, for packing purposes, certain substances may be assigned in accordance with their degree of danger. Packing group values: I, II and II
     * @param packagingGroup Packing Group means a group of which, for packing purposes, certain substances may be assigned in accordance with their degree of danger. Packing group values: I, II and II
     */
    public void setPackagingGroup(String packagingGroup) {
        this.packagingGroup = packagingGroup;
    }

    /**
     * Get the model number(s) of the labels/placards (see 5.2.2.2 and 5.3.1.7 <a href="https://unece.org/sites/default/files/2021-01/ADR2021_Vol1e_0.pdf">ADR2021_Vol1e_0.pdf</a> that have to be affixed to packages, containers, tank containers, portable tanks, MEGC’s and veh
     * @return The model number(s) of the labels/placards (see 5.2.2.2 and 5.3.1.7 <a href="https://unece.org/sites/default/files/2021-01/ADR2021_Vol1e_0.pdf">ADR2021_Vol1e_0.pdf</a> that have to be affixed to packages, containers, tank containers, portable tanks, MEGC’s and veh
     */
    public List<String> getDangerLabels() {
        return dangerLabels;
    }

    /**
     * Set the model number(s) of the labels/placards (see 5.2.2.2 and 5.3.1.7 <a href="https://unece.org/sites/default/files/2021-01/ADR2021_Vol1e_0.pdf">ADR2021_Vol1e_0.pdf</a> that have to be affixed to packages, containers, tank containers, portable tanks, MEGC’s and veh
     * @param dangerLabels The model number(s) of the labels/placards (see 5.2.2.2 and 5.3.1.7 <a href="https://unece.org/sites/default/files/2021-01/ADR2021_Vol1e_0.pdf">ADR2021_Vol1e_0.pdf</a> that have to be affixed to packages, containers, tank containers, portable tanks, MEGC’s and veh
     */
    public void setDangerLabels(List<String> dangerLabels) {
        this.dangerLabels = dangerLabels;
    }

    /**
     * @return
     */
    public String getDangerNumber() {
        return dangerNumber;
    }

    /**
     * @param dangerNumber
     */
    public void setDangerNumber(String dangerNumber) {
        this.dangerNumber = dangerNumber;
    }

    /**
     * Get the code to indicate tunnel category where restrictions apply to the passage of vehicles carrying dangerous goods. Categories A.B.C.D. and E as defined in 1.9.5.2.2. <a href="https://unece.org/sites/default/files/2021-01/ADR2021_Vol1e_0.pdf">ADR2021_Vol1e_0.pdf</a>
     * @return The code to indicate tunnel category where restrictions apply to the passage of vehicles carrying dangerous goods. Categories A.B.C.D. and E as defined in 1.9.5.2.2. <a href="https://unece.org/sites/default/files/2021-01/ADR2021_Vol1e_0.pdf">ADR2021_Vol1e_0.pdf</a>
     */
    public String getTunnelCode() {
        return tunnelCode;
    }

    /**
     * Set the code to indicate tunnel category where restrictions apply to the passage of vehicles carrying dangerous goods. Categories A.B.C.D. and E as defined in 1.9.5.2.2. <a href="https://unece.org/sites/default/files/2021-01/ADR2021_Vol1e_0.pdf">ADR2021_Vol1e_0.pdf</a>
     * @param tunnelCode The code to indicate tunnel category where restrictions apply to the passage of vehicles carrying dangerous goods. Categories A.B.C.D. and E as defined in 1.9.5.2.2. <a href="https://unece.org/sites/default/files/2021-01/ADR2021_Vol1e_0.pdf">ADR2021_Vol1e_0.pdf</a>
     */
    public void setTunnelCode(String tunnelCode) {
        this.tunnelCode = tunnelCode;
    }

    /**
     * Gets any special provisions.
     *
     * @return A string detailing special provisions, or {@code null} if none are specified.
     */
    public String getSpecialProvisions() {
        return specialProvisions;
    }

    /**
     * Sets special provisions.
     *
     * @param specialProvisions A string containing special provisions.
     */
    public void setSpecialProvisions(String specialProvisions) {
        this.specialProvisions = specialProvisions;
    }

    /**
     * Gets the points associated with this entity.
     *
     * @return An {@link Optional} containing the integer points if present, otherwise an empty Optional.
     */
    public Optional<Integer> getPoints() {
        return points;
    }

    /**
     * Sets the points associated with this entity.
     *
     * @param points An {@link Optional} containing the integer points to set, or an empty Optional if not applicable.
     */
    public void setPoints(Optional<Integer> points) {
        this.points = points;
    }

    /**
     * Gets the transport category for this entity.
     *
     * @return An {@link Optional} containing the {@link TransportCategory} if present, otherwise an empty Optional.
     */
    public Optional<TransportCategory> getTransportCategory() {
        return transportCategory;
    }

    /**
     * Sets the transport category for this entity.
     *
     * @param transportCategory An {@link Optional} containing the {@link TransportCategory} to set, or an empty Optional if not applicable.
     */
    public void setTransportCategory(Optional<TransportCategory> transportCategory) {
        this.transportCategory = transportCategory;
    }

    @Override
    public String toString() {
        return "Adr{" +
                "unNumber='" + unNumber + '\'' +
                ", language='" + language + '\'' +
                ", description='" + description + '\'' +
                ", technicalName='" + technicalName + '\'' +
                ", waste=" + waste +
                ", environmentallyHazardous=" + environmentallyHazardous +
                ", clazz='" + clazz + '\'' +
                ", classificationCode='" + classificationCode + '\'' +
                ", packagingGroup='" + packagingGroup + '\'' +
                ", dangerLabels=" + dangerLabels +
                ", dangerNumber='" + dangerNumber + '\'' +
                ", tunnelCode='" + tunnelCode + '\'' +
                ", specialProvisions='" + specialProvisions + '\'' +
                ", points=" + points +
                ", transportCategory=" + transportCategory +
                '}';
    }
}