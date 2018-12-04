package com.dream.domain;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by ning on 2017/9/3.
 */

@Table(name = "User")
@Entity
public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8057834312614187597L;
	
	@GeneratedValue
	@Id
    private Integer id;
    private String name;
    private String age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }
}
