<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />

<div class="container">          
    <img class="logo" src="images/logo.jpg" alt="Murach Logo"/>
    <h1>Survey</h1>
    <p>If you have a moment, we'd appreciate it if you would fill out this survey.</p>

    <form action="emailList" method="post">
        <input type="hidden" name="action" value="add">
        <h2>Your Information:</h2>

        <p class="errorMessage">${errorMessage}</p>

        <label for="firstName">First Name</label>
        <input type="text" id="firstName" name="firstName"><br>

        <label for="lastName">Last Name</label>
        <input type="text" id="lastName" name="lastName" ><br>

        <label for="email">Email</label>
        <input type="email" id="email" name="email" ><br>

        <label for="dateOfBirth">Date of Birth</label>
        <input type="text" id="dateOfBirth" name="dateOfBirth"><br>


        <h2>How did you hear about us?</h2>
        <div>
            <input type="radio" name="heardFrom" value="search" checked>Search engine
            <input type="radio" name="heardFrom" value="wordOfMouth">Word of mouth
            <input type="radio" name="heardFrom" value="socialMedia">Social Media
            <input type="radio" name="heardFrom" value="other">Other
        </div>


        <h2>Would you like to receive announcements about new CDs and special offers?</h2>
        <div>
            <input type="checkbox" name="contactOK" id="contactOK">
            <label for="contactOK">YES, I'd like that.</label><br>

            <input type="checkbox" name="emailOK" id="emailOK">
            <label for="emailOK">YES, please send me email announcements.</label>
        </div>


        <p>Please contact me by:
            <select name="contactMethod">
                <option value="email_postal">Email or postal mail</option>
                <option value="email_only">Email only</option>
                <option value="postal_only">Postal mail only</option>
            </select>
        </p>

         <label>&nbsp;</label>
        <input type="submit" value="Submit" id="submit">
    </form>
    </div>
<c:import url="/includes/footer.jsp" />
