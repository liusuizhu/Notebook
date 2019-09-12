// Author: John Liu
// Email: liusuizhu@gmail.com
package main

import (
	"array"
	"fmt"
)

func main() {
	arr := array.Constructor(20)
	for i := 0; i < 10; i ++ {
		arr.AddLast(i)
	}
	fmt.Println(arr)
	arr.RemoveFirst()
	fmt.Println(arr)
	arr.Add(2,100)
	fmt.Println(arr)
}
