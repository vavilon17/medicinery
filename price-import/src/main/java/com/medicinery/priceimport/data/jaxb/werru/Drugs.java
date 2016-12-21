package com.medicinery.priceimport.data.jaxb.werru;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Drugs {

    @XmlElement(name = "drug")
    private List<Drug> drugs;

    public Drugs() {
        this.drugs = new ArrayList<>();
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drug) {
        this.drugs = drug;
    }
}
