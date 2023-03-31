import socket

leftSpeed = 0
rightSpeed = 0

def forward():
    print("Forward")
    global leftSpeed
    global rightSpeed

    leftSpeed = 100
    rightSpeed = 100

def backward():
    print("Backward")
    global leftSpeed
    global rightSpeed

    leftSpeed = -100
    rightSpeed = -100

def left():
    print("Left")
    global leftSpeed
    global rightSpeed

    leftSpeed = 100
    rightSpeed = 50

def right():
    print("Right")
    global leftSpeed
    global rightSpeed

    leftSpeed = 50
    rightSpeed = 100

def stop():
    print("Stopping")
    global leftSpeed
    global rightSpeed

    leftSpeed = 0
    rightSpeed = 0

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

        currentCommand = command
        print(leftSpeed, rightSpeed)   
    except:
       try:
           s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
           s.connect(("10.45.76.113", 6666))
       except:
           print("Trying to connect to server")
