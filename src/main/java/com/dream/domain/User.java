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
	private String nickname;
    private String username;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
