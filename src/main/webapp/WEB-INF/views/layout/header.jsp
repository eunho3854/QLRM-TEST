<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">야구장</a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="/post/player">선수등록</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/post/team">팀등록</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/post/wherebase">구장등록</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/player">선수관리</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/team">팀관리</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/wherebase">구장관리</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/player/position">포지션선수</a>
    </li>
  </ul>
</nav>

