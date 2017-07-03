function validateQuantity(errorMessage) {
	var submitButton = document.getElementById("submitBasket");
	var inputQuantity = document.getElementsByClassName("form-control");
	var reg = new RegExp('^[0-9]+$');
	var erreur = false;
	var valueQuantity;
	for (var i = 0; i < inputQuantity.length; i++) {
		valueQuantity = inputQuantity[i].value;
		if (!valueQuantity.match(reg)) {
			erreur = true;
			inputQuantity[i].setCustomValidity(errorMessage);
		} else {
			if (valueQuantity > 10 || valueQuantity < 1) {
				erreur = true;
				inputQuantity[i].setCustomValidity(errorMessage);
			} else {
				inputQuantity[i].setCustomValidity('');
			}
		}
	}
	if (erreur) {
		submitButton.className = "btn btn-primary disabled";
	} else {
		submitButton.className = "btn btn-primary";
	}
}