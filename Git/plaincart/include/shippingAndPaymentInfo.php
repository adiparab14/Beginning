<?php
if (!defined('WEB_ROOT')
    || !isset($_GET['step']) || (int)$_GET['step'] != 1) {
	exit;
}

$errorMessage = '&nbsp;';
?>
<script language="JavaScript" type="text/javascript" src="library/checkout.js"></script>
<table width="550" border="0" align="center" cellpadding="10" cellspacing="0">
    <tr> 
        <td>Step 1 Of 3 : Enter Shipping And Payment Information </td>
    </tr>
</table>
<p id="errorMessage"><?php echo $errorMessage; ?></p>
<form action="<?php echo $_SERVER['PHP_SELF']; ?>?step=2" method="post" name="frmCheckout" id="frmCheckout" onSubmit="return checkShippingAndPaymentInfo();">
    <table width="550" border="0" align="center" cellpadding="5" cellspacing="1" class="entryTable">
        <tr class="entryTableHeader"> 
            <td colspan="2">Shipping Information</td>
        </tr>
        <tr> 
            <td width="150" class="label">First Name</td>
            <td class="content"><input name="txtShippingFirstName" type="text" class="box" id="txtShippingFirstName" size="30" maxlength="50"></td>
        </tr>
        <tr> 
            <td width="150" class="label">Last Name</td>
            <td class="content"><input name="txtShippingLastName" type="text" class="box" id="txtShippingLastName" size="30" maxlength="50"></td>
        </tr>
        <tr> 
            <td width="150" class="label">Address1</td>
            <td class="content"><input name="txtShippingAddress1" type="text" class="box" id="txtShippingAddress1" size="50" maxlength="100"></td>
        </tr>
        <tr> 
            <td width="150" class="label">Address2</td>
            <td class="content"><input name="txtShippingAddress2" type="text" class="box" id="txtShippingAddress2" size="50" maxlength="100"></td>
        </tr>
        <tr> 
            <td width="150" class="label">Phone Number</td>
            <td class="content"><input name="txtShippingPhone" type="text" class="box" id="txtShippingPhone" size="30" maxlength="32"></td>
        </tr>
        <tr> 
            <td width="150" class="label">Province / State</td>
            <td class="content"><input name="txtShippingState" type="text" class="box" id="txtShippingState" size="30" maxlength="32"></td>
        </tr>
        <tr> 
            <td width="150" class="label">City</td>
            <td class="content"><input name="txtShippingCity" type="text" class="box" id="txtShippingCity" size="30" maxlength="32"></td>
        </tr>
        <tr> 
            <td width="150" class="label">Postal / Zip Code</td>
            <td class="content"><input name="txtShippingPostalCode" type="text" class="box" id="txtShippingPostalCode" size="10" maxlength="10"></td>
        </tr>
    </table>
    <p>&nbsp;</p>
    <table width="550" border="0" align="center" cellpadding="5" cellspacing="1" class="entryTable">
        <tr class="entryTableHeader"> 
            <td width="150">Payment Information</td>
            <td><input type="checkbox" name="chkSame" id="chkSame" value="checkbox" onClick="setPaymentInfo(this.checked);"> 
                <label for="chkSame" style="cursor:pointer">Same as shipping information</label></td>
        </tr>
        <tr> 
            <td width="150" class="label">First Name</td>
            <td class="content"><input name="txtPaymentFirstName" type="text" class="box" id="txtPaymentFirstName" size="30" maxlength="50"></td>
        </tr>
        <tr> 
            <td width="150" class="label">Last Name</td>
            <td class="content"><input name="txtPaymentLastName" type="text" class="box" id="txtPaymentLastName" size="30" maxlength="50"></td>
        </tr>
        <tr> 
            <td width="150" class="label">Address1</td>
            <td class="content"><input name="txtPaymentAddress1" type="text" class="box" id="txtPaymentAddress1" size="50" maxlength="100"></td>
        </tr>
        <tr> 
            <td width="150" class="label">Address2</td>
            <td class="content"><input name="txtPaymentAddress2" type="text" class="box" id="txtPaymentAddress2" size="50" maxlength="100"></td>
        </tr>
        <tr> 
            <td width="150" class="label">Phone Number</td>
            <td class="content"><input name="txtPaymentPhone" type="text" class="box" id="txtPaymentPhone" size="30" maxlength="32"></td>
        </tr>
        <tr> 
            <td width="150" class="label">Province / State</td>
            <td class="content"><input name="txtPaymentState" type="text" class="box" id="txtPaymentState" size="30" maxlength="32"></td>
        </tr>
        <tr> 
            <td width="150" class="label">City</td>
            <td class="content"><input name="txtPaymentCity" type="text" class="box" id="txtPaymentCity" size="30" maxlength="32"></td>
        </tr>
        <tr> 
            <td width="150" class="label">Postal / Zip Code</td>
            <td class="content"><input name="txtPaymentPostalCode" type="text" class="box" id="txtPaymentPostalCode" size="10" maxlength="10"></td>
        </tr>
    </table>
    <p>&nbsp;</p>
    <table width="550" border="0" align="center" cellpadding="5" cellspacing="1" class="entryTable">
      <tr>
        <td width="150" class="entryTableHeader">Payment Method </td>
        <td class="content">
        <input name="optPayment" type="radio" id="optPaypal" value="paypal" checked="checked" />
        <label for="optPaypal" style="cursor:pointer">Paypal</label>
        <input name="optPayment" type="radio" value="cod" id="optCod" />
        <label for="optCod" style="cursor:pointer">Cash on Delivery</label></td>
      </tr>
    </table>
    <p>&nbsp;</p>
    <p align="center"> 
        <input class="box" name="btnStep1" type="submit" id="btnStep1" value="Proceed &gt;&gt;">
    </p>
</form>
