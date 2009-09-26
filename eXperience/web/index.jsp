<%-- 
    Document   : index
    Created on : 30.06.2009, 14:48:09
    Author     : PAV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script type="text/javascript"
                src="dojo/dojo/dojo.js"
        djConfig="parseOnLoad: true"></script>
        <script type="text/javascript">
            dojo.require("dojox.data.GoogleSearchStore");
            dojo.require("dijit.form.Button");

            function doSearch() {
                var queryString = dojo.byId("searchText").value;

                var store = new dojox.data.GoogleWebSearchStore();
                var list = dojo.byId("searchOutput");

                //Clean up any previous searches
                while(list.firstChild){
                    list.removeChild(list.firstChild);
                }

                store.fetch({
                    query:{text: queryString},
                    count: 20,
                    onComplete: function(items, request) {
                        //Print out the search results as an unordered
                        //list
                        var delay = 0;
                        dojo.forEach(items, function(item){
                            var li = document.createElement("li");
                            li.innerHTML =
                                "<a href=\"" +
                                store.getValue(item, "url")  +
                                "\">" +
                                store.getValue(item, "title") +
                                "</a>";
                            dojo.style(li, "opacity", "0");
                            list.appendChild(li);

                            //Fade in the results.
                            delay += 200;
                            dojo.fadeIn({node:li}).play(delay);
                        });
                    }
                });
            }
        </script>

        Enter search text
        <input type="text" size="40" value="dojo ajax"
               id="searchText"/>
        <div dojoType="dijit.form.Button" onclick="doSearch();">
            Search
        </div>

        <ul id="searchOutput" class="link-list"></ul>

    </body>
</html>
