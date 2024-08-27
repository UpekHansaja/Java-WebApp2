# Java-WebApp2
Java Web Application | Project - 02 using Java EE 7


### AJAX POST (`JSON`) Request

For this we have to use an external library know as `GSON` : [GSON 2.11.0](https://github.com/google/gson)

<br/>

 _**AJAX Request**_

```js
function userRegistration() {
    const mobile = document.getElementById("mobile").value;
    const name = document.getElementById("name").value;
    const gender = document.getElementById("male").checked?"Male":"Female";
    const country = document.getElementById("country").value;
    const password = document.getElementById("password").value;
    
    var user = {
        mobile:mobile,
        name:name,
        gender:gender,
        country:country,
        password:password,
    };
    
    var ajax = new XMLHttpRequest();
    ajax.open("POST","User_Registration", true);
    ajax.setRequestHeader("Content-Type","application/json");
    ajax.send(JSON.stringify(user));   
}
```


 _**User Bean**_

```java
package model;

import java.io.Serializable;

public class User implements Serializable {

    private String mobile;
    private String name;
    private String gender;
    private String country;
    private String password;
    
    public User(){
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }   
}
```


And finally below is the part which we use our `GSON` library,


 _**User Registration Servlet**_

```java
package controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;


@MultipartConfig
@WebServlet(name = "User_Registration", urlPatterns = {"/User_Registration"})
public class User_Registration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Gson gson = new Gson();
        User user = gson.fromJson(req.getReader(), User.class);
        
        System.out.println(user.getMobile());
        System.out.println(user.getName());
        System.out.println(user.getGender());
        System.out.println(user.getCountry());
        System.out.println(user.getPassword());
    }
}
```

***