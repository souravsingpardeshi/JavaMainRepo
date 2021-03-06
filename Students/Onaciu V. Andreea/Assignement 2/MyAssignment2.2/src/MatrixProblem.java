import java.math.BigDecimal;

public class MatrixProblem {
	public static void main(String[] args) {

		BigDecimal[][] matrixA = { { new BigDecimal(1), new BigDecimal(2), new BigDecimal(3), new BigDecimal(4) },
				{ new BigDecimal(5), new BigDecimal(6), new BigDecimal(7), new BigDecimal(8) },
				{ new BigDecimal(1), new BigDecimal(2), new BigDecimal(3), new BigDecimal(4) },
				{ new BigDecimal(1), new BigDecimal(2), new BigDecimal(3), new BigDecimal(4) } };
		BigDecimal[][] matrixB = { { new BigDecimal(1), new BigDecimal(0), new BigDecimal(0), new BigDecimal(0) },
				{ new BigDecimal(0), new BigDecimal(1), new BigDecimal(0), new BigDecimal(0) },
				{ new BigDecimal(0), new BigDecimal(0), new BigDecimal(1), new BigDecimal(0) },
				{ new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), new BigDecimal(1) } };
		System.out.println("The result of adding the two matrices: ");
		BigDecimal matrix[][] = MatrixOperations.add(matrixA, matrixB);
		MatrixOperations.printMatrix(matrix);

		System.out.println("The result of substracting the two matrices: ");
		matrix = MatrixOperations.substract(matrixA, matrixB);
		MatrixOperations.printMatrix(matrix);

		System.out.println("The result of multiplying the two matrices: ");
		matrix = MatrixOperations.multiply(matrixA, matrixB);
		MatrixOperations.printMatrix(matrix);

		System.out.println("The result of multipyling by a scalar the matrix A: ");
		matrix = MatrixOperations.multiplyScalar(matrixA, new BigDecimal("2"));
		MatrixOperations.printMatrix(matrix);

		System.out.println("The determinant of the matrix A: ");
		BigDecimal result = MatrixOperations.determinant(matrixA);
		System.out.println(result+"\n");

		System.out.println("Verify if matrices A and B are equal: ");
		boolean verify = MatrixOperations.areEqual(matrixA, matrixB);
		if (verify)
			System.out.println("Are equal."+"\n");
		else
			System.out.println("Are not equal."+"\n");

		System.out.println("Verify if matrices B has all the elements equal with zero: ");
		boolean isZero = MatrixOperations.isZeroMatrix(matrixB);
		if (isZero)
			System.out.println("It is azero matrix."+"\n");
		else
			System.out.println("It is not a zero matrix."+"\n");

		System.out.println("Verify if matrices B is identity matrix: ");
		boolean isIdentity = MatrixOperations.isIdentityMatrix(matrixB);
		if (isIdentity)
			System.out.println("It is the identity matrix."+"\n");
		else
			System.out.println("It is not the identity matrix."+"\n");

		System.out.println("The fill degree of the matrix A: ");
		BigDecimal degree = MatrixOperations.fillDegree(matrixA);
		System.out.println(degree + "%"+"\n");
	}
}