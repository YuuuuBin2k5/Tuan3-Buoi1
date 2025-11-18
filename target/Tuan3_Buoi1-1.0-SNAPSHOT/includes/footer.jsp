        <%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>
        <%
            GregorianCalendar currentDate = new GregorianCalendar();
            int currentYear = currentDate.get(Calendar.YEAR);
        %>
        <p class="text-footer">&copy; Copyright <%= currentYear %> Mike Murach &amp; Associates</p>
    </body>
</html>
