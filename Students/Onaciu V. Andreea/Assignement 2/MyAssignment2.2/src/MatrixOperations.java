
import java.math.BigDecimal;

public class MatrixOperations {

	static BigDecimal[][] add(BigDecimal[][] matrixA, BigDecimal[][] matrixB) {

		int nrRowsA = matrixA.length;
		int nrRowsB = matrixB.length;
		int nrColumnsA = matrixA[0].length;
		int nrColumnsB = matrixB[0].length;

		if (nrRowsA != nrRowsB || nrColumnsA != nrColumnsB)
			return null;
		BigDecimal[][] result = new BigDecimal[nrRowsA][nrColumnsA];

		for (int i = 0; i < nrRowsA; i++)
			for (int j = 0; j < nrColumnsA; j++) {
				result[i][j] = matrixA[i][j].add(matrixB[i][j]);
			}

		return result;
	}

	static BigDecimal[][] substract(BigDecimal[][] matrixA, BigDecimal[][] matrixB) {
		int nrRowsA = matrixA.length;
		int nrRowsB = matrixB.length;
		int nrColumnsA = matrixA[0].length;
		int nrColumnsB = matrixB[0].length;

		if (nrRowsA != nrRowsB || nrColumnsA != nrColumnsB)
			return null;
		BigDecimal[][] result = new BigDecimal[nrRowsA][nrColumnsA];

		for (int i = 0; i < nrRowsA; i++)
			for (int j = 0; j < nrColumnsA; j++) {
				result[i][j] = matrixA[i][j].subtract(matrixB[i][j]);
			}

		return result;
	}

	static BigDecimal[][] multiply(BigDecimal[][] matrixA, BigDecimal[][] matrixB) {
		int nrRowsA = matrixA.length;
		int nrRowsB = matrixB.length;
		int nrColumnsA = matrixA[0].length;
		int nrColumnsB = matrixB[0].length;
		if (nrColumnsA != nrRowsB)
			return null;
		BigDecimal[][] result = new BigDecimal[nrRowsA][nrColumnsB];
		for (int i = 0; i < result.length; i++)
			for (int j = 0; j < result[0].length; j++)
				result[i][j] = new BigDecimal("0");
		for (int i = 0; i < nrRowsA; i++)
			for (int k = 0; k < nrColumnsB; k++)
				for (int j = 0; j < nrColumnsA; j++) {
					result[i][k] = result[i][k].add(matrixA[i][j].multiply(matrixB[j][k]));
				}
		return result;
	}

	static BigDecimal[][] multiplyScalar(BigDecimal[][] matrixA, BigDecimal scalar) {
		BigDecimal[][] result = new BigDecimal[matrixA.length][matrixA[0].length];
		for (int i = 0; i < matrixA.length; i++)
			for (int j = 0; j < matrixA[0].length; j++)
				result[i][j] = matrixA[i][j].multiply(scalar);
		return result;
	}

	static BigDecimal determinant(BigDecimal[][] matrixA) { // method sig. takes
															// a matrix (two
															// dimensional
															// array), returns
															// determinant.
		BigDecimal result = new BigDecimal("0");
		BigDecimal s;
		if (matrixA.length == 1) {
			return (matrixA[0][0]);
		}
		for (int i = 0; i < matrixA.length; i++) {
			BigDecimal[][] reducedMatrix = new BigDecimal[matrixA.length - 1][matrixA.length - 1];
			for (int j = 1; j < matrixA.length; j++) {
				for (int k = 0; k < matrixA.length; k++) {
					if (k < i) {
						reducedMatrix[j - 1][k] = matrixA[j][k];
					} else if (k > i) {
						reducedMatrix[j - 1][k - 1] = matrixA[j][k];
					}
				}
			}
			if (i % 2 == 0) {
				s = new BigDecimal(1);
			} else {
				s = new BigDecimal(-1);
			}

			result = result.add((s.multiply(matrixA[0][i])).multiply(determinant(reducedMatrix)));
		}
		return (result);
	}

	static boolean areEqual(BigDecimal[][] matrixA, BigDecimal[][] matrixB) {
		int nrRowsA = matrixA.length;
		int nrRowsB = matrixB.length;
		int nrColumnsA = matrixA[0].length;
		int nrColumnsB = matrixB[0].length;

		if (nrRowsA != nrRowsB || nrColumnsA != nrColumnsB)
			return false;

		for (int i = 0; i < nrRowsA; i++)
			for (int j = 0; j < nrColumnsA; j++) {
				if (!matrixA[i][j].equals(matrixB[i][j]))
					return false;
			}

		return true;
	}

	static boolean isZeroMatrix(BigDecimal[][] matrixA) {
		int nrRowsA = matrixA.length;
		int nrColumnsA = matrixA[0].length;
		for (int i = 0; i < nrRowsA; i++)
			for (int j = 0; j < nrColumnsA; j++) {
				if (!matrixA[i][j].equals(new BigDecimal("0")))
					return false;
			}
		return true;
	}

	static boolean isIdentityMatrix(BigDecimal[][] matrixA) {
		int nrRowsA = matrixA.length;
		int nrColumnsA = matrixA[0].length;
		for (int i = 0; i < nrRowsA; i++)
			for (int j = 0; j < nrColumnsA; j++) {
				if (i != j)
					if (!matrixA[i][j].equals(new BigDecimal("0")))
						return false;
				if (i == j)
					if (!matrixA[i][j].equals(new BigDecimal("1")))
						return false;
			}
		return true;

	}

	static BigDecimal fillDegree(BigDecimal[][] matrixA) {
		int nrRowsA = matrixA.length;
		int nrColumnsA = matrixA[0].length;
		BigDecimal elements = new BigDecimal(0);
		for (int i = 0; i < nrRowsA; i++)
			for (int j = 0; j < nrColumnsA; j++) {
				if (!matrixA[i][j].equals(new BigDecimal("0")))
					elements = elements.add(new BigDecimal("1"));
			}

		BigDecimal result = (elements.multiply(new BigDecimal("100"))).divide(new BigDecimal(nrRowsA * nrColumnsA));
		return result;
	}

	static void printMatrix(BigDecimal[][] matrixA){
		int nrRowsA = matrixA.length;
		int nrColumnsA = matrixA[0].length;
	
		for (int i = 0; i < nrRowsA; i++){
			System.out.println("");
			for (int j = 0; j < nrColumnsA; j++) {
				System.out.print(matrixA[i][j]+" ");
			}
		}
		System.out.println("\n");
		  
	}
}
