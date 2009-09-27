/*
	Copyright (c) 2004-2006, The Dojo Foundation
	All Rights Reserved.

	Licensed under the Academic Free License version 2.1 or above OR the
	modified BSD license. For more information on Dojo licensing, see:

		http://dojotoolkit.org/community/licensing.shtml
*/



djd43.provide("djd43.dnd.Sortable");
djd43.require("djd43.dnd.*");
djd43.dnd.Sortable = function () {
};
djd43.lang.extend(djd43.dnd.Sortable, {ondragstart:function (e) {
	var dragObject = e.target;
	while (dragObject.parentNode && dragObject.parentNode != this) {
		dragObject = dragObject.parentNode;
	}
	return dragObject;
}});

