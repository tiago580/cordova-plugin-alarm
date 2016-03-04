module.exports = {
    alert: function (title, message, buttonLabel, successCallback, failureCallback) {
        cordova.exec(successCallback, failureCallback, "Alert", "alert", [title, message, buttonLabel])
    }
}