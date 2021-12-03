package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;
@JacksonXmlRootElement(localName = "export")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Export {
    @JacksonXmlProperty(localName = "export_begin")
    private String export_begin;
    @JacksonXmlProperty(localName = "contacts")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Contacts contacts;
    @JacksonXmlProperty(localName = "export_end")
    private String export_end;

    public Export() {
    }

    @Override
    public String toString() {
        return "Export{" +
                "export_begin='" + export_begin + '\'' +
                ", contacts=" + contacts +
                ", export_end='" + export_end + '\'' +
                '}';
    }

    public String getExport_begin() {
        return export_begin;
    }

    public void setExport_begin(String export_begin) {
        this.export_begin = export_begin;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public String getExport_end() {
        return export_end;
    }

    public void setExport_end(String export_end) {
        this.export_end = export_end;
    }
}
