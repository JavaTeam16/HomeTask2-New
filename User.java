
// Part 2: Metadata Management
class Metadata {
private String projectName; private String projectVersion; private String projectDescription; private List<String> authors; private String contactDetails;
public Metadata(String projectName, String projectVersion, String projectDescription, List<String> authors, String contactDetails) {
this.projectName = projectName; this.projectVersion = projectVersion; this.projectDescription = projectDescription; this.authors = authors;
this.contactDetails = contactDetails; }
public String getProjectName() {
return projectName; }
public String getProjectVersion() {
return projectVersion; }
public String getProjectDescription() {
return projectDescription; }
public List<String> getAuthors() {
return authors; }
public String getContactDetails() {
return contactDetails; }
}
class MetadataManager { private Metadata metadata;
public MetadataManager() {
metadata = new Metadata("Electric Vehicle Charging Station", "1.0", "A system for

managing electric vehicle charging stations", Arrays.asList("Alice Smith", "Bob Jones"), "contact@example.com");
}
public Metadata getMetadata() {
return metadata; }
public void updateMetadata(Metadata newMetadata) {
metadata = newMetadata; }
}
