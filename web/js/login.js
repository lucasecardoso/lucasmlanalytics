/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $("form").submit(function (event) {
        var u = document.getElementById("username").value;
        var p = document.getElementById("password").value;
        
        $.ajax({
            url: 'LoginServlet',
            type: 'POST',
            data: {
                "username": u,
                "password": p
            },
            
            success : function(resp) {
                alert(JSON.stringify(resp));
                if (resp === "OK") 
                    window.location = "analytics.jsp";
                else 
                    window.location = "error.jsp";
            }
        });
    });
});
