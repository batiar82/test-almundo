**Test almunndo.com:**
* Compilar con 
```
mvn compile
```
```
mvn test-compile
```
**Para Usar:**
* Instanciar una o varias llamadas con un id y una duracion:
```
Call call=new Call(i,Duration.ofSeconds(duration));
```
* Instanciar un dispatcher:
```
Dispatcher dispatcher=new Dispatcher();
```
o sino:
```
Dispatcher dispatcher=new Dispatcher(int cantOperadores, int cantSupervisores, int cantidadDirectores);
```
Por defecto se crean 10 empleados manejados por la dao MemoryEmployeeDaoImpl

* Llamar a dispatchCall(call) para que la llamada sea asignada a un empleado libre por el dispatcher:
```
dispatcher.dispatchCall(call);
```
Por consola se puede ver el procesamiento de las llamadas logueadas. Loguear con DEBUG en log4j.properties para mas detalle.

* Una vez finalizado el procesado de llamadas terminar el dispatcher con shutdown:
```
dispatcher.shutdown();
```

* Ejemplo de log con 10 llamados:
```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running test.CallCenterTest
18-03-2018 11:51:54 INFO  Call:62 - Employee id: 4 of class: class model.impl.Operator is about to answer the callId :3 that lasts 6 seconds.
18-03-2018 11:51:54 INFO  Call:62 - Employee id: 10 of class: class model.impl.Director is about to answer the callId :9 that lasts 9 seconds.
18-03-2018 11:51:54 INFO  Call:62 - Employee id: 9 of class: class model.impl.Director is about to answer the callId :8 that lasts 7 seconds.
18-03-2018 11:51:54 INFO  Call:62 - Employee id: 8 of class: class model.impl.Supervisor is about to answer the callId :7 that lasts 6 seconds.
18-03-2018 11:51:54 INFO  Call:62 - Employee id: 6 of class: class model.impl.Supervisor is about to answer the callId :5 that lasts 8 seconds.
18-03-2018 11:51:54 INFO  Call:62 - Employee id: 7 of class: class model.impl.Supervisor is about to answer the callId :6 that lasts 8 seconds.
18-03-2018 11:51:54 INFO  Call:62 - Employee id: 1 of class: class model.impl.Operator is about to answer the callId :0 that lasts 6 seconds.
18-03-2018 11:51:54 INFO  Call:62 - Employee id: 2 of class: class model.impl.Operator is about to answer the callId :1 that lasts 8 seconds.
18-03-2018 11:51:54 INFO  Call:62 - Employee id: 3 of class: class model.impl.Operator is about to answer the callId :2 that lasts 9 seconds.
18-03-2018 11:51:54 INFO  Call:62 - Employee id: 5 of class: class model.impl.Operator is about to answer the callId :4 that lasts 9 seconds.
18-03-2018 11:52:00 INFO  Call:64 - Employee id: 4 of class: class model.impl.Operator finished answering the callId :3 that lasts 6 seconds.
18-03-2018 11:52:00 INFO  Call:64 - Employee id: 8 of class: class model.impl.Supervisor finished answering the callId :7 that lasts 6 seconds.
18-03-2018 11:52:00 INFO  Call:64 - Employee id: 1 of class: class model.impl.Operator finished answering the callId :0 that lasts 6 seconds.
18-03-2018 11:52:01 INFO  Call:64 - Employee id: 9 of class: class model.impl.Director finished answering the callId :8 that lasts 7 seconds.
18-03-2018 11:52:02 INFO  Call:64 - Employee id: 7 of class: class model.impl.Supervisor finished answering the callId :6 that lasts 8 seconds.
18-03-2018 11:52:02 INFO  Call:64 - Employee id: 6 of class: class model.impl.Supervisor finished answering the callId :5 that lasts 8 seconds.
18-03-2018 11:52:02 INFO  Call:64 - Employee id: 2 of class: class model.impl.Operator finished answering the callId :1 that lasts 8 seconds.
18-03-2018 11:52:03 INFO  Call:64 - Employee id: 10 of class: class model.impl.Director finished answering the callId :9 that lasts 9 seconds.
18-03-2018 11:52:03 INFO  Call:64 - Employee id: 3 of class: class model.impl.Operator finished answering the callId :2 that lasts 9 seconds.
18-03-2018 11:52:03 INFO  Call:64 - Employee id: 5 of class: class model.impl.Operator finished answering the callId :4 that lasts 9 seconds.
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 11.101 sec
```
