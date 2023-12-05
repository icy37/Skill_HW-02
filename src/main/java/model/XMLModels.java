package model;

import jakarta.xml.bind.annotation.*;

import java.util.Date;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLModels {
    @XmlElementWrapper(name = "studentsInfo")
    @XmlElement(name = "studentEntry")
    private List<Student> studentList;

    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universityEntry")
    private List<University> universityList;

    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    private List<Statistics> statisticsList;

    @XmlElement(name = "processedAt")
    private Date processDate;

    public XMLModels() {
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public XMLModels setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        return this;
    }

    public List<University> getUniversityList() {
        return universityList;
    }

    public XMLModels setUniversityList(List<University> universityList) {
        this.universityList = universityList;
        return this;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public XMLModels setStatisticsList(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
        return this;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public XMLModels setProcessDate(Date processDate) {
        this.processDate = processDate;
        return this;
    }
}