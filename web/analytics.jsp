<%-- 
    Document   : analytics
    Created on : Jan 10, 2016, 10:45:58 AM
    Author     : Lucas
--%>
<%@ page session="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Analytics</title>
        <script type="text/javascript" src="js/jquery-2.2.0.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/chartist.js"></script>
        <script type="text/javascript" src="js/jquery.cookie.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/simple-sidebar.css" rel="stylesheet">
        <link href="css/chartist.min.css" rel="stylesheet">
        <link href="css/analytics.css" rel="stylesheet">
    </head>
    <body>
        <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul id="sidebar-ul" class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#" style="color: white">
                        Lucas' ML Analytics
                    </a>
                </li>
                <li>
                    <div class="user-profile">
                        <a href="#" id="user-title" class="user-title" style="color: white; font-size:150%"></a>
                        <div id="user-btns" style="display: none">
                            <button onclick="logout();" class="btn btn-sm">Logout</button>
                        </div>
                    </div>
                </li>
                <li>
                    <input id="query" type="text" name="search" style="width: 80%"/>
                </li>
                <li>
                    <button id="go" type="submit" style="width: 80%" class="btn btn-large">Buscar</button>
                </li>
                <li>
                    <div style="font-size:150%; color:#fff">
                        Mis Búsquedas
                    </div>
                </li>
            </ul>
        </div>
        <div id="page-content-wrapper">
            <div class="main-container">
                <div class="charts-header"> 
                    <h3 class="ind-title">Indicadores</h3>
                </div>
                <div class="chart-container panel panel-default" >
                    <div class="panel-heading">
                        <h3 class="panel-title">Proporción Tiendas - Vendedores Particulares</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="centering-div">
                                <div class="ct-chart chart col-md-12" id="seller-chart"></div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="centering-div">
                                    <div class="color-box" style="background-color: #009688;"></div>
                                    <div class="loquesea col-sm-10">Tiendas</div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="centering-div">
                                    <div class="color-box" style="background-color: #FFC107;"></div>
                                    <div class="loquesea col-sm-10">Particulares</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="chart-container panel panel-default">
                    <div class="chart-title panel-heading">
                        <h3 class="panel-title">Proporción Usados - Nuevos</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="centering-div">
                                <div class="ct-chart chart col-md-12" id="condition-chart"></div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="centering-div">
                                    <div class="color-box" style="background-color: #00BCD4;"></div>
                                    <div class="loquesea col-sm-10">Nuevos</div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="centering-div">
                                    <div class="color-box" style="background-color: #CDDC39;"></div>
                                    <div class="loquesea col-sm-10">Usados</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="chart-container panel panel-default">
                    <div class="chart-title panel-heading">
                        <h3 class="panel-title">Cantidad de ventas por usuario en la primer página</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="ct-chart ct-condition-chart chart" id="trans-agg-chart"></div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="centering-div">
                                    <div class="color-box" style="background-color: #D70206;"></div>
                                    <div class="loquesea col-sm-10">Total</div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="centering-div">
                                    <div class="color-box" style="background-color: #F05B4F;"></div>
                                    <div class="loquesea col-sm-10">Completadas</div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="centering-div">
                                    <div class="color-box" style="background-color: #F4C63D;"></div>
                                    <div class="loquesea col-sm-10">Canceladas</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>

        <!-- /#sidebar-wrapper -->

        <!-- Modal spinner -->
        <div class="my-modal">
        </div>
    </body>
    
    <script type="text/javascript">    
        $(document).ready(function(e) {
            var username = $.cookie('username');
            
            checkSession('${cookie.JSESSIONID.value}');
            getQueries(username);
            
            var title = $('#user-title');
            title.text('Bienvenido, ' + username + '!');
            title.click(function() {
                title.siblings('#user-btns').slideToggle();
            });
            
            $('#go').click(function(e) {
                var q = document.getElementById("query").value;
                
                if ($.trim(q) === "") {
                    $input = $('#query');
                    $input.css('background-color', 'rgb(242, 222, 222)');
                    $input.val("");
                    $input.focus();
                    return;
                } else {
                    $input = $('#query');
                    $input.css('background-color', 'white');
                }
                
                if (isQueryInArray(q)) {
                    //We got an already existing query
                    if ($.cookie('new_session') === undefined) {
                        //New session, need to update database
                        performSearch(q, username, "N", "new");
                        $.cookie("new_session", "Y" );
                    } else {
                        performSearch(q, username, "N", "old");
                    }
                } else {
                    performSearch(q, username, "Y", "new");
                }
            });
        });
        
        function getQueries(username) {
            $.ajax({
                url: 'QueryServlet',
                type: 'POST',
                data: {
                    "username" : username
                },
                
                success : function(resp) {
                    queries = resp;                    
                    setUpPaginators();
                    showQueries(1);
                }
            });
        }
        
        function isQueryInArray(q) {
            for (var i = 0; i < queries.length; i++) {
                if (queries[i].query === q)
                    return true;
            }
            
            return false;
        }
        
        function setUpPaginators() {
            var pages = Math.trunc(queries.length / 11) + 1;
            
            //Check if div already exists before attempting to add it
            if ($('#pag-div').length) {
                //We simply update the page amount
                $('.page-counter').html('Pág 1 of ' + pages);
                $('.page-counter').attr('id', '1');
                $('#pg-next').unbind('click');
                $('#pg-back').unbind('click');
                $('#pg-next').bind('click', {totalPages: pages}, clickNext);
                $('#pg-back').bind('click', {totalPages: pages}, clickBack);
                
                if(pages > 1) {
                    $('#pg-next').removeClass('disabled');
                } else {
                    $('#pg-next').addClass('disabled');
                }
                
            } else {
                $('#sidebar-ul').append($('<div id="pag-div"></div>'));
                $('#pag-div').append($('<ul id="paginator" class="pager"></ul>'));
                var $pager = $('#paginator');

                $pager.append('<li class="pager-prev my-pager"><a id="pg-back" href="#">Atr</a></li>');
                $pager.append('<li class="page-counter my-pager" id="1">Pág 1 of ' + pages + '</li>');
                $pager.append('<li class="pager-next my-pager"><a id="pg-next" href="#">Sig</a></li>');

                $('#pg-next').bind('click', {totalPages: pages}, clickNext);

                $('#pg-back').bind('click', {totalPages: pages}, clickBack);
                
                if (pages == 1) {
                    $('#pg-next').addClass('disabled');
                }
                
                $('#pg-back').addClass('disabled');
            }
        }
        
        function clickNext (event) {
            if ($(this).hasClass("disabled"))
                return;
            $counter = $('.page-counter');
            var nextPage = parseInt($counter.attr('id')) + 1;
            showQueries(nextPage);
            $counter.attr('id', nextPage);
            $counter.html('Pág ' + nextPage + ' of ' + event.data.totalPages);
            $('#pg-back').removeClass("disabled");
            if (nextPage === (event.data.totalPages)) {
                $(this).addClass("disabled");
            }

        }
        
        function clickBack (event) {
            if ($(this).hasClass("disabled")) {   
                return;
            }

            $counter = $('.page-counter');
            var prevPage = parseInt($counter.attr('id')) - 1;
            showQueries(prevPage);
            $counter.attr('id', prevPage);
            $counter.html('Pág ' + prevPage + ' of ' + event.data.totalPages);

            $('#pg-next').removeClass("disabled");

            if (prevPage === 1) {
                $(this).addClass("disabled");
            }
        }
        
        function showQueries(pageNumber) {
            startFrom = (pageNumber * 10) - 10;
            console.log(startFrom);
            $('.query-li').remove();
            
            for (i = startFrom; i < queries.length && i < (startFrom + 10); i++) {
                var q = queries[i].query;
                
                if (q === "")
                    q = 'blank';
                
                var btn = $('<button class="btn-sm search">Buscar</button>');
                var delBtn = $('<button class="btn-sm del">Borrar</button>');
                var li = $('<li class="page-item query-li"></li>');
                var a = $('<a href="#" class="query-elm" id="' + queries[i].id + '">' + q + '</a>');
                var div = $('<div class="abm centering-div" style="display: none;"></div></li>');
                
                if (i === 0)
                    $('.page-item').addClass('active');

                btn.click(function() {
                    if ($.cookie('new_session') === undefined) {
                        performSearch($(this).parent().siblings('.query-elm').text(), $.cookie('username'), 'N', 'new');
                        $.cookie('new_session', 'Y');
                    } else {
                        performSearch($(this).parent().siblings('.query-elm').text(), $.cookie('username'), 'N', 'old');
                    }
                });

                delBtn.click(function() {
                    deleteQuery($(this).parent().siblings('.query-elm'));
                    var searchId = $(this).parent().siblings('.query-elm').attr('id');
                    for (var i = 0; i < queries.length; i++) {
                        if (queries[i].id == searchId) {
                            queries.splice(i, 1);
                        }
                    }
                    
                });

                div.append(btn);
                div.append(delBtn);

                a.click(listClick);

                li.append(a).append(div).appendTo('#sidebar-ul');
            }
        }
        
        function checkSession(sessionId) {
            $.ajax({
                url: 'SessionServlet',
                type: 'POST',
                data : { "sessionId" : sessionId },
                
                success : function(resp) {
                    if (resp === "NOK") {
                        window.location.href = "login.jsp";
                    }
                }
            });
        }
        
        function listClick() {
            $(this).siblings('.abm').slideToggle();
        };
        
        //Set the loading spinner
        $body = $("body");
        
        $(document).on({
            ajaxStart: function() { $body.addClass("loading"); },
            ajaxStop: function() { $body.removeClass("loading"); }
        });
        
        function performSearch(q, username, newQuery, session) {
            $.ajax({
                    url: 'SearchServlet',
                    type: 'POST',
                    data: {
                        "username" : username,
                        "query" : q,
                        "new" : newQuery,
                        "session" : session
                    },
                    
                    success : function(resp) {
                        processResponse(resp);
                        setUpPaginators();
                        showQueries(1);
                    }
                });
        }
        
        function deleteQuery(e) {
            $.ajax({
                url: 'DeleteServlet',
                type: 'POST',
                data: {
                    "id" : e.prop('id')
                },
                
                success : function(resp) {
                    e.parent().slideToggle();
                } 
            });
        }
        
        function processResponse(resp) {
            
            var q = resp.query;
            var sti = resp.sellerTypeI;
            var ci = resp.conditionI;
            var ta = resp.transactionAggregates;
            
            createSellerTypeChart(sti);
            createConditionBarChart(ci);
            createTransAggChart(ta);
            
            if (isQueryInArray(q.query)) 
            {
                
            }
            else {
                queries.push(q);
            }
            
            $('.chart-container').css("display", "block");
            $('.ind-title').html('Indicadores - ' + q.query);
        }
        
        function createSellerTypeChart(sti) {
            var data = {
                series: [{ 
                    value: sti.brandAm,
                    className: "seller-brand-color"
                 },
                 {
                    value: sti.normalAm,
                    className: "seller-normal-color"
                }]
            };
            
            createPieChart(data, '#seller-chart');
        }
        
        function createConditionBarChart(ci) {
            var data = {
                //series: [ ci.newItems, ci.usedItems ]
                series: [{
                    value: ci.newItems,
                    className: "condition-new-color"
                },
                {
                    value: ci.usedItems,
                    className: "condition-used-color"
                }]
            };
            
            createPieChart(data, '#condition-chart');
        }
        
        function createTransAggChart(ta) {
            var nameArr = [];
            var totalArr = [];
            var completedArr = [];
            var failedArr = [];
            
            for (var i = 0; i < ta.length; i++) {
                nameArr.push(ta[i].sellerName);
                totalArr.push(ta[i].total);
                completedArr.push(ta[i].completed);
                failedArr.push(ta[i].failed);
            }
            
            data = {
                labels: nameArr,
                series: [ totalArr, completedArr, failedArr ]
            };
            
            createBarChart(data, '#trans-agg-chart');
       }
        
        function createPieChart(data, elm) {
            
            var sum = function(a, b) { return a + b };
            
            var options = {
                height: 300,
                width: 300,
                labelInterpolationFnc: function(value) {
                    var s = [];
                    for (var i = 0; i < data.series.length; i++) {
                        s.push(data.series[i].value);
                    }
                    
                    var result = Math.round(value / s.reduce(sum) *100)  + '%';
                    if (result === "0%")
                        return "";
                    else
                        return result;
                }
            };
                        
            new Chartist.Pie(elm, data, options);
        }
        
        function createBarChart(data, elm) {
            var options = {
                height: 500,
                seriesBarDistance: 10
            };
            
            var responsiveOptions = [
                ['screen and (max-width:640px)', {
                    seriesBarDistance: 0,
                    axisX: {
                        labelInterpolationFnc: function(value) {
                            return value[0];
                        }
                    }
                }]
            ];
            
            new Chartist.Bar(elm, data, options, responsiveOptions);
        }
        
        function logout() {
            $.ajax({
                url: 'LogoutServlet',
                type: 'GET',
                
                success: function(resp) {
                    window.location.href = "login.jsp";
                }
            });
        }
    </script>
    
</html>
