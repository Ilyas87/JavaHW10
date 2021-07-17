<%@ page import="org.itstep.Lesson10.entity.Car" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%@include file="templates/bootstrap.jsp"%>
</head>
<body>
<div class="container-fluid">
    <%@include file="templates/navbar.jsp"%>
</div>
<div class="container mt-5">
    <div class="row">
        <div class="col-sm-4">
            <form method="post" action="/index">
                <div class="form-group">
                    <label class="form-label">NAME</label>
                    <input type="text" class="form-control " placeholder="Put car name" name="name">
                </div>
                <div class="form-group mt-2">
                    <label class="form-label">ENGINE VOLUME</label>
                    <input type="number" min="0" step="0.1" class="form-control" placeholder="Put engine volume" name="engine_volume">
                </div>
                <div class="form-group mt-2">
                    <label class="form-label">PRICE</label>
                    <input type="number" class="form-control" placeholder="Put price" name="price" min="0" value="2000">
                </div>
                <button class="btn btn-success mt-2">Add Car</button>
            </form>
        </div>
        <div class="col-sm-12 mt-5">
            <table class="table table-striped text-center">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">NAME</th>
                    <th scope="col">PRICE</th>
                    <th scope="col">ENGINE VOLUME</th>
                    <th scope="col">SETTINGS</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Car> cars = (List<Car>)request.getAttribute("cars");
                    for (Car car : cars) {
                %>
                <tr>
                    <td>
                        <%=car.getId()%>
                    </td>
                    <td>
                        <%=car.getName()%>
                    </td>
                    <td>
                        <%=car.getEngineVolume()%>
                    </td>
                    <td>
                        <%=car.getPrice()%>
                    </td>
                    <td>
                        <form method="post" action="/delete">
                            <input type="hidden" name="id" value="<%=car.getId()%>">
                            <button class="btn btn-danger w-100">Delete</button>
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>