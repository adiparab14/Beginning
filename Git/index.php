<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Shoutbox for NETTUTS by Dan Harper
<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>
<div id="container">

  <h1>Shoutbox

  <h5><a href="http://www.danharper.me" title="Dan Harper">Dan Harper </a> : <a href="http://www.nettuts.com" title="NETTUTS - Spoonfed Coding Skills">NETTUTS</a></h5>

  <div id="boxtop" />
  <div id="content">
<?php
$self = $_SERVER['PHP_SELF']; //the $self variable equals this file
$ipaddress = ("$_SERVER[REMOTE_ADDR]"); //the $ipaddress var equals users IP
include ('db.php'); // for db details

$connect = mysql_connect($host,$username,$password) or die('
<p class="error">Unable to connect to the database server at this time.');

mysql_select_db($database,$connect) or die('
<p class="error">Unable to connect to the database at this time.');
