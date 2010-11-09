<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form id="memberForm" commandName="memberForm" method="post"
	action="addMember.html" >
	
	Имя <form:input path="name" id="name" />
	<br />
	Отчество <form:input path="patronymic" id="patronymic" />
	<br />	
	Фамилия <form:input path="surName" id="surName" />
	<br />
	Дата рождения <form:input path="birthDate" id="birthDate" />
	<br />
	Пол <form:input path="gender" id="gender" />
	<br />
	Гражданство <form:input path="citizenship" id="citizenship" />
	<br />
	Регион <form:select path="regionId">
		<form:options items="${regions}" itemValue="regionID" itemLabel="regionName" />
	</form:select>
	Населенный пункт <form:input path="location" id="location" />
	<br />
	Индекс <form:input path="postCode" id="postCode" />
	<br />
	Улица <form:input path="street" id="street" />
	<br />
	Дом <form:input path="houseNumber" id="houseNumber" />
	<br />
	Корпус <form:input path="unitNumber" id="unitNumber" />
	<br />
	Квартира <form:input path="appartmentNumber" id="appartmentNumber" />
	<br />
	Моб. <form:input path="mobilePhone" id="mobilePhone" />
	<br />
	Рабочий <form:input path="workPhone" id="workPhone" />
	<br />
	Домашний <form:input path="homePhone" id="homePhone" />
	<br />
	E-mail <form:input path="email" id="email" />
	<br />
	
	
	<input type="submit" name="_cancel" value="Отмена" />
	<input type="submit" name="_finish" value="Ok" />
</form:form>