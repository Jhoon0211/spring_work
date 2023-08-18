package aaa.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class OrderData {

	OrderAddr ad;
	ArrayList<OrderProduct> arr;
}
