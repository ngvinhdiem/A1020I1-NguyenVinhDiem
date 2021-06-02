
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src=https://code.jquery.com/jquery-1.12.4.js></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<header>
    <%@include file="../body/header.jsp" %>
</header>

        <div align="center">
            <form method="post">
                <table border="1" cellpadding="5">
                    <br>  <h3>Them Moi Mat Bang</h3> <br>
                    <tr>
                        <th>Ma mat bang:</th>
                        <td>
                            <input type="text" name="maMatBang" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Trang Thai :</th>
                        <td>
                            <select class="form-control form-select" name="trangThai">
                                <option value="Trong">Trong</option>
                                <option value="Ha Tang">Ha Tang</option>
                                <option value="Day Du">Day Du</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Dien Tich:</th>
                        <td>
                            <input type="text" name="dienTich" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Tang :</th>
                        <td>
                            <select class="form-control form-select" name="tang">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                                <option value="13">13</option>
                                <option value="14">14</option>
                                <option value="15">15</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Tang :</th>
                        <td>
                            <select class="form-control form-select" name="loaiMatBang">
                                <option value="Chia Se">Chia Se</option>
                                <option value="Tron Goi">Tron Goi</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Gia Tien:</th>
                        <td>
                            <input type="text" name="giaTien" size="45"/>
                            <span>VND</span>
                        </td>
                    </tr>
                    <tr>
                        <th>Ngay Bat Dau:</th>
                        <td>
                            <input type="date"  name="ngayBatDau" size="45">
                        </td>
                    </tr>
                    <tr>
                        <th>Ngay Ket Thuc:</th>
                        <td>
                            <input type="date"  name="ngayKetThuc" size="45">
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Them"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>


<footer>
    <%@include file="../body/footer.jsp" %>
</footer>

</body>
</html>
