**Test almundo.com:**
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
18-03-2018 12:05:10,983 INFO  Call:62 - Employee id: 3 of class: class model.impl.Operator is about to answer the callId :0 that lasts 6 seconds.
18-03-2018 12:05:10,984 INFO  Call:62 - Employee id: 5 of class: class model.impl.Operator is about to answer the callId :2 that lasts 9 seconds.
18-03-2018 12:05:10,983 INFO  Call:62 - Employee id: 4 of class: class model.impl.Operator is about to answer the callId :1 that lasts 5 seconds.
18-03-2018 12:05:10,985 INFO  Call:62 - Employee id: 6 of class: class model.impl.Operator is about to answer the callId :3 that lasts 5 seconds.
18-03-2018 12:05:10,986 INFO  Call:62 - Employee id: 7 of class: class model.impl.Operator is about to answer the callId :4 that lasts 10 seconds.
18-03-2018 12:05:10,987 INFO  Call:62 - Employee id: 8 of class: class model.impl.Supervisor is about to answer the callId :5 that lasts 5 seconds.
18-03-2018 12:05:10,989 INFO  Call:62 - Employee id: 9 of class: class model.impl.Supervisor is about to answer the callId :6 that lasts 9 seconds.
18-03-2018 12:05:10,990 INFO  Call:62 - Employee id: 10 of class: class model.impl.Supervisor is about to answer the callId :7 that lasts 9 seconds.
18-03-2018 12:05:10,991 INFO  Call:62 - Employee id: 1 of class: class model.impl.Director is about to answer the callId :8 that lasts 8 seconds.
18-03-2018 12:05:10,992 INFO  Call:62 - Employee id: 2 of class: class model.impl.Director is about to answer the callId :9 that lasts 10 seconds.
18-03-2018 12:05:15,985 INFO  Call:64 - Employee id: 4 of class: class model.impl.Operator finished answering the callId :1 that lasts 5 seconds.
18-03-2018 12:05:15,985 INFO  Call:64 - Employee id: 6 of class: class model.impl.Operator finished answering the callId :3 that lasts 5 seconds.
18-03-2018 12:05:15,989 INFO  Call:64 - Employee id: 8 of class: class model.impl.Supervisor finished answering the callId :5 that lasts 5 seconds.
18-03-2018 12:05:16,984 INFO  Call:64 - Employee id: 3 of class: class model.impl.Operator finished answering the callId :0 that lasts 6 seconds.
18-03-2018 12:05:18,991 INFO  Call:64 - Employee id: 1 of class: class model.impl.Director finished answering the callId :8 that lasts 8 seconds.
18-03-2018 12:05:19,984 INFO  Call:64 - Employee id: 5 of class: class model.impl.Operator finished answering the callId :2 that lasts 9 seconds.
18-03-2018 12:05:19,990 INFO  Call:64 - Employee id: 9 of class: class model.impl.Supervisor finished answering the callId :6 that lasts 9 seconds.
18-03-2018 12:05:19,990 INFO  Call:64 - Employee id: 10 of class: class model.impl.Supervisor finished answering the callId :7 that lasts 9 seconds.
18-03-2018 12:05:20,986 INFO  Call:64 - Employee id: 7 of class: class model.impl.Operator finished answering the callId :4 that lasts 10 seconds.
18-03-2018 12:05:20,992 INFO  Call:64 - Employee id: 2 of class: class model.impl.Director finished answering the callId :9 that lasts 10 seconds.
```
