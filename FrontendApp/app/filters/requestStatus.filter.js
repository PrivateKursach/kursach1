function requestStatusFilter() {
    return function (status) {
        if (status == 0) {
            return "На рассмотрении";
        } else if (status == 1) {
            return "Одобрена";
        } else {
            return "";
        }
    };
}