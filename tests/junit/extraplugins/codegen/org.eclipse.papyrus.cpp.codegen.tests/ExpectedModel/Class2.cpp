// --------------------------------------------------------
// Code generated by Papyrus C++
// --------------------------------------------------------

#define CppCodegenTest_Class2_BODY

/************************************************************
 Class2 class body
 ************************************************************/

// include associated header file
#include "CppCodegenTest/Class2.h"

// Derived includes directives

// Include from Include declaration (body)
#include <string.h>
// End of Include declaration (body)

// static attributes (if any)

/**
 * Default constructor
 */
Class2::Class2() {
	iVal1 = 0;
	iVal2 = 0;
	bVal = false;
}

/**
 * Constructor with parameters
 * @param newIVal1 
 * @param newIVal2 
 * @param newBVal 
 */
Class2::Class2(int /*in*/newIVal1, int /*in*/newIVal2, bool /*in*/newBVal) {
	iVal1 = newIVal1;
	iVal2 = newIVal2;
	bVal = newBVal;
}

/**
 * Virtual method
 * @param a 
 * @param b 
 * @return  
 */
double Class2::virtualOp(double /*in*/a, double /*in*/b) {
	return;
}

/**
 * Static method
 */
void Class2::staticOp() {
}

/**
 * Friend method
 */
void Class2::friendOp() {
}

/**
 * Non-static method
 */
void Class2::nonStaticOp() {
}

/**
 * Method with in, out, inout, return parameters
 * @param in 
 * @param out 
 * @param inout 
 * @return ret 
 */
int Class2::paramsOp(int /*in*/in, int* /*out*/out, int* /*inout*/inout) {
}

/**
 * Void Method
 * @return  
 */
void Class2::voidOp() {
}

/**
 * 
 * @param newIVal1 
 */
void Class2::defaultValueOp(int /*in*/newIVal1) {
}

/**
 * Virtual destructor
 */
Class2::~Class2() {
}

/**
 * 
 * @param c1 
 * @return  
 */
Class1 Class2::classesOp(Class1 /*in*/c1) {
}

/**
 * Const method
 */
void Class2::constOp() const {
	std::cout << "I am a const method" << std::endl;
}

/************************************************************
 End of Class2 class body
 ************************************************************/
