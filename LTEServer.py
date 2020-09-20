from BaseHTTPServer import BaseHTTPRequestHandler,HTTPServer 

 

class myHandler(BaseHTTPRequestHandler):
       def do_POST(self):

                      import time

                      time.sleep(1)

                      self.send_response(200)

server = HTTPServer(('', 8081), myHandler)

print 'Started LTE-B server on port ' , 8081

server.serve_forever()