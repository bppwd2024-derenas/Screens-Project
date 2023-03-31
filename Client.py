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

currentCommand = ""

while True:
    try:
        command = s.recv(1024).decode().strip()

        if(command == "forward" and currentCommand != "forward"): forward()
        elif(command == "backward" and currentCommand != "backward"): backward()
        elif(command == "left" and currentCommand != "left"): left()
        elif(command == "right"  and currentCommand != "right"): right()

        elif(command == "unforward" and currentCommand == "forward"): stop()
        elif(command == "unbackward" and currentCommand == "backward"): stop()
        elif(command == "unleft" and currentCommand == "left"): stop()
        elif(command == "unright" and currentCommand == "right"): stop()

        currentCommand = command;   
    except:
       try:
           s.close()
           s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
           s.connect(("10.45.76.113", 6666))
       except:
           print("Trying to connect to server")
