let qaImage = document.createElement("img");
qaImage.setAttribute("src", "QA-Consulting-Logo.jpg");

let quoteLogoDiv = document.createElement("div");
quoteLogoDiv.setAttribute("id", "qaLogo");
quoteLogoDiv.append(qaImage);

let containerDiv = document.createElement("div");
containerDiv.setAttribute("id", "container");
containerDiv.append(quoteLogoDiv);

document.body.prepend(containerDiv);

let surprise = function () {
    let quoteDiv = document.createElement("div");
    quoteDiv.setAttribute("id", "quote");

    let header = document.createElement("h1");
    let subheader = document.createElement("h2");

    header.innerText = "Surprise!";

    quoteDiv.append(header);

    containerDiv.append(quoteDiv);
}

setTimeout(surprise, 2000);
