<%-- 
    Document   : login
    Created on : Jan 9, 2016, 8:03:24 PM
    Author     : Lucas
--%>

<%  // Load the JDBC driver
  try {
    System.out.println("Loading driver...");
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("Driver loaded!");
  } catch (ClassNotFoundException e) {
    throw new RuntimeException("Cannot find the driver in the classpath!", e);
  }
%>

<%@ page session="false" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<script type="text/javascript" src="js/jquery-2.2.0.min.js"> </script>

<script type="text/javascript" src="js/bootstrap.min.js"></script>

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/login.css" rel="stylesheet">
    </head>
    <body>
        <br>
        <div class="container-fluid">
            <div class="panel panel-success">
                <div class="panel-heading" align="center">
                    <h4><b><font color="white">Lucas' ML Analytics</font> </b></h4>
                </div>
                <div class="panel-body"align="center">

                    <div class="modal-body" style="margin-top: 10%; margin-bottom: 10%; margin-left: 25%; margin-right: 25%;">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#Login" data-toggle="tab">Ingreso</a>
                            <li><a href="#Registration" data-toggle="tab">Registro</a>
                        </ul>

                        <div class="tab-content" style="padding-top: 10px; border-left: 1px solid #ddd; border-right: 1px solid #ddd; border-bottom: 1px solid #ddd">
                            <div class="tab-pane fade in active" id="Login">
                                <form role="form" class="form-horizontal">
                                    <div class="form-group">
                                        <label for="email" class="col-sm-2 control-label">
                                            Usuario</label>
                                        <div class="col-sm-10">
                                            <input class="form-control" id="username-login" placeholder="Username" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword1" class="col-sm-2 control-label">
                                            Contraseña</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" id="password-login" placeholder="Password" />
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-2"></div>
                                        <div class="col-sm-10">
                                            <div class="alert alert-danger" id="login-error">
                                                <strong>Usuario o contraseña incorrectos</strong>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-2"></div>
                                        <div class="col-sm-10">
                                            <button class="btn btn-lg btn-primary btn-block" id="btn-login">Ingreso</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="tab-pane fade" id="Registration">
                                <form role="form" class="form-horizontal">
                                    <div class="form-group">
                                        <label for="email" class="col-sm-2 control-label">
                                            Usuario</label>
                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" id="username-reg" placeholder="Username" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="password" class="col-sm-2 control-label">
                                            Contraseña</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" id="password-reg" placeholder="Password" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="password" class="col-sm-2 control-label">
                                            Confirmar contraseña</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" id="pass-repeat-reg" placeholder="Confirm Password" />
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-2"></div>
                                        <div class="col-sm-10">
                                            <div class="alert alert-danger" id="register-error">
                                                <strong>Las contraseñas no coinciden</strong>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-2"></div>
                                        <div class="col-sm-10">
                                            <div class="alert alert-success" id="register-success">
                                                <strong>¡Registro exitoso!</strong>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-2"></div>
                                        <div class="col-sm-10">
                                            <div class="alert alert-danger" id="register-fatal">
                                                <strong>Ocurrió un error durante el proceso de registro</strong>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-2">
                                        </div>
                                        <div class="col-sm-10">
                                            <button type="button" id="btn-reg" class="btn btn-primary btn-block">Registro</button>
                                        </div>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <script type="text/javascript">
            $(document).ready(function(e) {
                $('#btn-login').click(function(e) {
                    e.preventDefault();
                    var username = $('#username-login').val();
                    var password = $('#password-login').val();
                    login(username, password);
                });
                
                $('#btn-reg').click(function(e) {
                    e.preventDefault();
                    var username = $('#username-reg');
                    var password = $('#password-reg');
                    var passwordCheck = $('#pass-repeat-reg');
                    
                    if(password.val() !== passwordCheck.val()) {
                        password.css('background-color', '#f2dede');
                        passwordCheck.css('background-color', '#f2dede');
                        
                        $('#register-error').fadeToggle();
                        return false;
                    }
                    registerUser(username.val(), password.val());
                });
            });
            
            
            
            function login(username, password) {
                $.ajax({
                    url: 'LoginServlet',
                    type: 'POST',
                    data: { "username" : username, password: password },
                    
                    success: function (resp) {
                        if (resp === "OK") 
                            window.location.href = "analytics.jsp";
                        else
                            $('#login-error').show();
                    }
                });
            }
            
            function registerUser(username, password) {
                $.ajax({
                    url : 'RegisterServlet', 
                    type : 'POST',
                    data : { "username" : username, "password" : password },

                    success : function(resp) {
                        var regAlert = $('#register-error');
                        var regSucc = $('#register-success');
                        var regFatal = $('#register-fatal');
                        
                        if (resp === "OK") {
                            if (regAlert.is(':visible')) regAlert.fadeToggle();
                            if (regSucc.is(':hidden')) regSucc.fadeToggle();
                            $('#password-reg').css('background-color', 'white');
                            $('#pass-repeat-reg').css('background-color', 'white');
                            
                            setTimeout(function() {
                                login(username, password);
                            }, 2000);
                        } else {
                            if (regAlert.is(':visible')) regAlert.fadeToggle();
                            if (regSucc.is(':visible')) regSucc.fadeToggle();
                            if (regFatal.is(':hidden')) regFatal.fadeToggle();
                        }
                        
                        
                    }
                });
            }
        </script>
    </body>
</html>
