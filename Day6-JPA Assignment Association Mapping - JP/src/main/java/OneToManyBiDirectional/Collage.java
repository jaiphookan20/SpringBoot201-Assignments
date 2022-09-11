package OneToManyBiDirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/* Q/- Write a JPA application to implement One To Many bidirectional mapping 
 * One College - Many Students
 * */

@Entity
public class Collage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int collageId;
	private String collageName;
	private String collageAddress;
	
	
	/* One College - Many Students so in the One Entity Class -> Create a Collection type of the Many Entity Class 
	 * to  store a List or Set of the Many Entity Type
	 * & Add the OneToMany Annotation to it
	 * */

	@OneToMany(mappedBy="collage" ,cascade=CascadeType.ALL)
	private List<Student> studentList = new ArrayList<Student>();
	
	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public Collage() {
		
	}
	
	public Collage(int collageId, String collageName, String collageAddress, List<Student> studentList) {
		super();
		this.collageId = collageId;
		this.collageName = collageName;
		this.collageAddress = collageAddress;
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "Collage [collageId=" + collageId + ", collageName=" + collageName + ", collageAddress=" + collageAddress
				+ ", studentList=" + studentList + "]";
	}

	public int getCollageId() {
		return collageId;
	}

	public void setCollageId(int collageId) {
		this.collageId = collageId;
	}

	public String getCollageName() {
		return collageName;
	}

	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}

	public String getCollageAddress() {
		return collageAddress;
	}

	public void setCollageAddress(String collageAddress) {
		this.collageAddress = collageAddress;
	}


	
}
