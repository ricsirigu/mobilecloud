## Running the VideoService ##

To run the service:

Build with Netbeans or import the project in Eclipse


## Accessing the Service

After launching VideoService, you can interact with it by going to the following url

`http://localhost:8080/2-videoservice/video`

The service accepts GET and POST request.
Accepts and returns videos in json format.
It also performs validation on the fields submitted.

To upload a Video use curl or PostMan plugin for google chrome.

Either way the format for the POST request is the following:

Using curl

`curl -i -XPOST -H "Content-type: application/json" -d "{\"duration\":1435,\"name\":\"CoolVideo\",\"url\":\"www.youtube.com\"}" http://localhost:8080/2-videoservice/video`

And here an example of GET request, if you feel adventurous and for you the browser isn't enough:


`curl -H "Accept: application/json" http://localhost:8080/2-videoservice/video`


