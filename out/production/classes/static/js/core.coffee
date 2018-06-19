class Passboy

  @server: "http://192.168.0.104:8080"
  @apiLogin: "/api/loginbyemail"
  @loginInput: document.querySelector ".wrap-login-input input"
  @loginButton: document.querySelector ".wrap-login-button"

  @init: () ->

    console.log "Init..."
    @listener @loginButton, "click", () =>

      @post @server + @apiLogin, { e: @loginInput.value }, (data) =>

        alert data

  @listener: (element, event, callback) ->

    element.addEventListener event, callback

  @post: (url, data, callback) ->

    xhr = new XMLHttpRequest()
    xhr.open "POST", url, true
    xhr.send JSON.stringify data
    xhr.onreadystatechange = () =>

      if xhr.readyState is 4 then callback xhr.responseText

Passboy.init()