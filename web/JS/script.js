
function userRegistration() {
    const mobile = document.getElementById("mobile").value;
    console.log(mobile);

    const name = document.getElementById("name").value;
    console.log(name);

    const gender = document.getElementById("male").checked?"Male":"Female";
    console.log(gender);

    const country = document.getElementById("country").value;
    console.log(country);

    const password = document.getElementById("password").value;
    console.log(password);
    
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