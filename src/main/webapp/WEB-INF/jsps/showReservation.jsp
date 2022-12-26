<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
<h2>Flight Details</h2>
Flight Number:${flight.flightNumber}</br>
Operating Airlines:${flight.operatingAirlines}</br>
Departure City:${flight.departureCity}</br>
Arrival City:${flight.arrivalCity}</br>
Departure Date:${flight.dateOfDeparture}</br>

<h2>Enter Passenger Details</h2>
<form action="confirmReservation" method="post">
<pre>
First Name:<input type="text" name="firstName"/>
Last Name:<input type="text" name="lastName"/>
Middle Name: <input type="text" name="middleName"/>
Email:<input type="email" name="email"/>
Phone :<input type="number" name="phone"/>
</pre>
<input type="hidden" name="flightId" value="${flight.id}"/>
<h2>Enter Payment Details</h2>
<pre>
Name On The Card <input type="text" name="cardHolderName"/>
Card Number <input type="number" name="cardNumber"/>
Cvv<input type="number" name="cvv"/>
Expiry Date <input type="text" name="expiryDate"/>
Amount:<input type="number" name="amount"/>
</br>
<input type="submit" value="Complete Reservation"/>
</pre>
</form>
</body>
</html>