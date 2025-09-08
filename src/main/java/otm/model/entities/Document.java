package otm.model.entities;

public class Document extends OtmEntity {
    /**
     * The content of the document. There are two different options on how the content can be provided. Either through an external link to where the content lives. Or directly as an encoded base64 string.
     */
    private Content content;

    /**
     * The type of the document, such as a photo, text document, PDF etc.
     */
    private String documentType;

    /**
     * The name of the file.
     */
    private String filename;

    /**
     * The official MIME type of the file. See <a href="https://en.wikipedia.org/wiki/Media_type">Wikepedia</a> for more information.
     */
    private String mimeType;

    /**
     * The description of the file, for example what purpose it serves.
     */
    private String description;

    /**
     * The actor who owns the document. If not provided, the creator will be assumed to be the owner.
     */
    private Actor creator;

    /**
     * The actor who owns the document.
     * If not provided, the creator will be assumed to be the owner.
     */
    private Actor owner;

    // Getters and setters

    /**
     * Gets the content of the document.
     *
     * @return The document content.
     */
    public Content getContent() {
        return content;
    }

    /**
     * Sets the content of the document.
     *
     * @param content The document content to set.
     */
    public void setContent(Content content) {
        this.content = content;
    }

    /**
     * Gets the type of the document.
     *
     * @return The document type.
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * Sets the type of the document.
     *
     * @param documentType The document type to set.
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    /**
     * Gets the filename of the document.
     *
     * @return The filename.
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Sets the filename of the document.
     *
     * @param filename The filename to set.
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Gets the MIME type of the document.
     *
     * @return The MIME type.
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Sets the MIME type of the document.
     *
     * @param mimeType The MIME type to set.
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    /**
     * Gets the description of the document.
     *
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the document.
     *
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the creator of the document.
     *
     * @return The creator.
     */
    public Actor getCreator() {
        return creator;
    }

    /**
     * Sets the creator of the document.
     *
     * @param creator The creator to set.
     */
    public void setCreator(Actor creator) {
        this.creator = creator;
    }

    /**
     * Gets the owner of the document.
     *
     * @return The owner.
     */
    public Actor getOwner() {
        return owner;
    }

    /**
     * Sets the owner of the document.
     *
     * @param owner The owner to set.
     */
    public void setOwner(Actor owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Document{" +
                "content=" + content +
                ", documentType='" + documentType + '\'' +
                ", filename='" + filename + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", description='" + description + '\'' +
                ", creator=" + creator +
                ", owner=" + owner +
                '}';
    }
}