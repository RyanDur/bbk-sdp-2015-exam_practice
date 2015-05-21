package main.scala

final case class Node[+A](head: A, tail: LinkedList[A]) extends LinkedList[A] {

  val size = 1 + tail.size

  val isEmpty: Boolean = false
}

case object Empty extends LinkedList[Nothing] {
  val size = 0

  val isEmpty: Boolean = true

  override def head: Nothing = ???

  override def tail: LinkedList[Nothing] = ???
}

sealed trait LinkedList[+A] {

  def size: Int

  def isEmpty: Boolean

  def tail: LinkedList[A]

  def head: A

  def toList: List[A] = this match {
    case Empty => List()
    case Node(h, tl) => h :: tl.toList
  }

  def setHead[B >: A](v: B): LinkedList[B] = ???

  def ::[B >: A](element: B): LinkedList[B] = ???

  def dropWhile(f: A => Boolean): LinkedList[A] = ???

  def ++[B >: A](that: LinkedList[B]): LinkedList[B] = ???

  def foldLeft[B](acc: B)(f: (B, A) => B): B = ???

  def fold[B >: A](acc: B)(f: (B, B) => B): B = ???

  def reverse(): LinkedList[A] = ???

  def foldRight[B](acc: B)(f: (A, B) => B): B = ???

  def reduce[B >: A](f: (B, B) => B): B = ???

  def filter(p: A => Boolean): LinkedList[A] = ???

  def find(p: (A) => Boolean): Option[A] = ???

  def map[B](f: A => B): LinkedList[B] = ???

  def flatten[B]: LinkedList[B] = ???

  def flatMap[B](f: A => LinkedList[B]): LinkedList[B] = ???

  def negate[B >: A](predicate: B => Boolean): B => Boolean = ???

  def partition(p: (A) => Boolean): (LinkedList[A], LinkedList[A]) = ???

  // Manually test
  def foreach(f: A => Unit): Unit = ???

  def zip[B](that: LinkedList[B]): LinkedList[(A, B)] = ???

  def collect[B](pf: PartialFunction[A, B]): LinkedList[B] = ???

  // use an immutable map
  def groupBy[K](f: (A) => K): Map[K, LinkedList[A]] = ???

  def splitAt(n: Int): (LinkedList[A], LinkedList[A]) = ???

  // make it work for only Int, don't worry about Generics for this method
  def mergeSort(): LinkedList[Int] = ???
}

object LinkedList {
  def apply[A](items: A*): LinkedList[A] =
    items.foldRight(Empty: LinkedList[A])(Node(_, _))
}