# Web Service Practical Steps using NetBeans and GlassFish

---

# STEP 1 — Open Output Window

If output is not visible:

```text
Window → Output
```

---

# STEP 2 — Create Server Project

```text
File
→ New Project
→ Java Web
→ Web Application
→ Next
```

Project Name:

```text
Assignment-7
```

Select:

```text
Server = GlassFish Server 4.1.1
Java EE Version = Java EE 7 Web
```

Click:

```text
Finish
```

---

# STEP 3 — Increase Font Size (Optional)

```text
Tools
→ Options
→ Fonts & Colors
→ Click Right Side Icon
→ Select Font = Lucida Sans
→ Size = 18
→ OK
```

---

# STEP 4 — Create Web Service

Right Click Project:

```text
New
→ Web Service
```

Name:

```text
MyCalculatorWebService
```

Package:

```text
com.myservice
```

Select:

```text
Create from Scratch
```

Click:

```text
Finish
```

---

# STEP 5 — Add Operations

Right Click:

```text
Web Services
→ MyCalculatorWebService
→ Add Operation
```

Examples:

```text
addition
subtraction
multiplication
division
```

Add:
- Method Name
- Return Type
- Parameters

Click:

```text
OK
```

---

# STEP 6 — Build and Deploy Server

Right Click Project:

```text
Clean and Build
```

Then:

```text
Deploy
```

---

# STEP 7 — Test Web Service

Right Click:

```text
Web Services
→ MyCalculatorWebService
→ Test Web Service
```

Browser opens:

```text
...?Tester
```

Replace:

```text
?Tester
```

with:

```text
?wsdl
```

You should see:

```xml
<?xml version="1.0"
```

---

# STEP 8 — Create Client Project

```text
File
→ New Project
→ Java Web
→ Web Application
```

Project Name:

```text
CalculatorWebServiceClient
```

Click:

```text
Finish
```

---

# STEP 9 — Create HTML Form

```text
Window
→ IDE Tools
→ Palette
```

Drag Form into:

```text
index.html
```

Action Name:

```text
CalculatorServlet
```

---

# STEP 10 — Add Web Service Client

Right Click Client Project:

```text
New
→ Web Service Client
```

Select:

```text
WSDL URL
```

Paste:

```text
http://localhost:8080/Assignment-7/MyCalculatorWebService?wsdl
```

Click:

```text
Finish
```

---

# STEP 11 — Create Servlet

Copy form action name:

```text
CalculatorServlet
```

Right Click Client Project:

```text
New
→ Servlet
```

Servlet Name:

```text
CalculatorServlet
```

Select:

```text
Add information to deployment descriptor
```

Click:

```text
Finish
```

---

# STEP 12 — Drag Web Service into Servlet

Expand:

```text
Web Service References
→ MyCalculatorWebService
```

Drag service method into:

```text
CalculatorServlet.java
```

Initialize variables and write servlet logic.

Note:
- Input field names in HTML must match servlet parameter names.

---

# STEP 13 — Clean and Build Client

Right Click Client Project:

```text
Clean and Build
```

Expected Output:

```text
BUILD SUCCESSFUL
```

---

# STEP 14 — Run Application

Open:

```text
Web Pages
→ index.html
```

Right Click:

```text
Run File
```

---

# COMMON ERROR FIXES

# ERROR 500 / WSDL Errors

Delete manually:

```text
build
dist
nbproject/private
```

from client project folder.

---

# FIX FOR @WebServiceRef ERROR

Open:

```java
CalculatorServlet.java
```

Remove:

```java
import javax.xml.ws.WebServiceRef;
```

Remove:

```java
@WebServiceRef(...)
```

Replace:

```java
private MyCalculatorWebService_Service service;
```

with:

```java
private MyCalculatorWebService_Service service =
        new MyCalculatorWebService_Service();
```

---

# QUICK ERROR MAPPING

| Error | Cause | Fix |
|---|---|---|
| package does not exist | Old reference deleted | Re-add service |
| HTML lang attribute error | Used ?Tester | Use ?wsdl |
| WEB-INF/wsdl not found | WSDL not copied | Remove @WebServiceRef |
| MyCalculatorWebService_Tester | Wrong import | Delete and re-add |
| HTTP 500 | Runtime injection issue | Manual new Service() |

---

# RESULT

The web service and client application were successfully created, deployed, and executed using NetBeans and GlassFish Server.