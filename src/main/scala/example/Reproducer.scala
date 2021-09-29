package example

import example.Reproducer.ClassWithoutLambda

object Reproducer {

  class ClassWithLambda(sup: () => Long)
  class ClassWithVar(var msg: String) extends ClassWithLambda(() => 1)
  class ClassWithoutVar(msg: String) extends ClassWithLambda(() => 1)

  class ClassWithoutLambda(something: Int)
  class ClassWithVarExtendingNotLambda(var msg: String) extends ClassWithoutLambda(1)


  val _ = new ClassWithoutVar("foo") // This can be instantiated at runtime
  val _ = new ClassWithVarExtendingNotLambda("foo") // This can be instantiated at runtime
  val _ = new ClassWithVar("foo") // This fails with java.lang.VerifyError: Bad type on operand stack
  /*
  (run-main-a) java.lang.VerifyError: Bad type on operand stack
  [error] Exception Details:
  [error]   Location:
  [error]     example/Reproducer$ClassWithVar.<init>(Ljava/lang/String;)V @10: invokevirtual
  [error]   Reason:
  [error]     Type uninitializedThis (current frame, stack[2]) is not assignable to 'example/Reproducer$ClassWithVar'
  [error]   Current Frame:
  [error]     bci: @10
  [error]     flags: { flagThisUninit }
  [error]     locals: { uninitializedThis, 'java/lang/String' }
  [error]     stack: { uninitializedThis, 'example/Reproducer$', uninitializedThis }
  [error]   Bytecode:
  [error]     0x0000000: 2a2b b500 0f2a b200 152a b600 18b6 001c
  [error]     0x0000010: b700 1fb1
  [error] java.lang.VerifyError: Bad type on operand stack
  [error] Exception Details:
  [error]   Location:
  [error]     example/Reproducer$ClassWithVar.<init>(Ljava/lang/String;)V @10: invokevirtual
  [error]   Reason:
  [error]     Type uninitializedThis (current frame, stack[2]) is not assignable to 'example/Reproducer$ClassWithVar'
  [error]   Current Frame:
  [error]     bci: @10
  [error]     flags: { flagThisUninit }
  [error]     locals: { uninitializedThis, 'java/lang/String' }
  [error]     stack: { uninitializedThis, 'example/Reproducer$', uninitializedThis }
  [error]   Bytecode:
  [error]     0x0000000: 2a2b b500 0f2a b200 152a b600 18b6 001c
  [error]     0x0000010: b700 1fb1
  [error]
  [error] 	at example.Reproducer$.<clinit>(Reproducer.scala:19)
  [error] 	at example.main.main(Reproducer.scala:21)
  [error] 	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
  [error] 	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
  [error] 	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
  [error] 	at java.lang.reflect.Method.invoke(Method.java:498)
  */

  def main(args: Array[String]): Unit = {
    println("it worked")
  }
}
