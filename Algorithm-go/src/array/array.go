// Author: John Liu
// Email: liusuizhu@gmail.com
package array

import (
	"bytes"
	"fmt"
	"strconv"
)

type array struct {
	data []int
	size int
}

func Constructor(capacity int) *array {
	return &array{
		data: make([]int, capacity),
	}
}

func (this *array) GetCapacity() int {
	return len(this.data)
}

func (this *array) GetSize() int {
	return this.size
}

func (this *array) IsEmpty() bool {
	return this.size == 0
}

func (this *array) Add(index int, e int)  {
	if this.size == len(this.data) {
		panic("Add failed. Array is full.")
	}
	if index < 0 || index > this.size {
		panic("Add failed. Require index >= 0 and index <= size")
	}

	for i := this.size - 1; i>= index; i --  {
		this.data[i + 1] = this.data[i]
	}

	this.data[index] = e
	this.size ++
}

func (this *array) AddFirst(e int)  {
	this.Add(0, e)
}

func (this *array) AddLast(e int) {
	this.Add(this.size, e)
}

func (this *array) Remove(index int) int {
	if index < 0 || index > this.size {
		panic("Remove failed. Require index >= 0 and index <= size")
	}
	ret := this.data[index]
	for i := index + 1; i < this.size; i ++ {
		this.data[i - 1] = this.data[i]
	}
	this.size --
	return ret
}

func (this *array) RemoveFirst() int {
	return this.Remove(0)
}

func (this *array) RemoveLast() int {
	return  this.Remove(this.size - 1)
}

func (this *array) Set(index int, e int)  {
	if index < 0 || index > this.size {
		panic("Set failed. Require index >= 0 and index <= size")
	}
	this.data[index] = e
}

func (this *array) Find(e interface{}) int {
	for i := 0; i < this.size; i++ {
		if Interfaces.Compare(this.data[i], e) == 0 {
			return i
		}
	}
	return -1;
}

func (this *array) Contains(e int) bool {
	for i := 0; i < this.size; i ++ {
		if this.data[i] == e {
			return true
		}
	}
	return false
}

func (this *array) String() string {
	var buffer bytes.Buffer

	buffer.WriteString(fmt.Sprintf("Array: size = %d, capacity = %d\n", this.size, len(this.data)))
	buffer.WriteString("[")
	for i := 0; i < this.size; i++ {
		buffer.WriteString(strconv.Itoa(this.data[i]))
		if i != (this.size - 1) {
			buffer.WriteString(", ")
		}
	}
	buffer.WriteString("]")
	return buffer.String()
}