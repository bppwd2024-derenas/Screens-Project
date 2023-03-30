import socket

def forward():
    print("Forward")

def backward():
    print("Backward")

def left():
    print("Left")

def right():
    print("Right")

def stop():
    print("Stopping")

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
currentCommand = ""

s.connect(("10.45.76.113", 6666))

while True:
    try:
        command = s.recv(1024).decode().strip()

        if(command == "forward" and currentCommand != "forward"): forward()
        if(command == "backward" and currentCommand != "backward"): backward()
        if(command == "left" and currentCommand != "left"): left()
        if(command == "right"  and currentCommand != "right"): right()

        if(command == "unforward" and currentCommand == "forward"): stop()
        if(command == "unbackward" and currentCommand == "backward"): stop()
        if(command == "unleft" and currentCommand == "left"): stop()
        if(command == "unright" and currentCommand == "right"): stop()

        currentCommand = command;   
    except:
       try:
           s.close()
           s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
           s.connect(("10.45.76.113", 6666))
       except:
           print("Trying to connect to server")
