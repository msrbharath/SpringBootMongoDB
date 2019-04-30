package in.bharath.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.bharath.models.Collectionzz;
import in.bharath.models.CollectionzzRepository;

@RestController
@RequestMapping("/mongo")
public class PerfController {

	@Autowired
	CollectionzzRepository collectionzzRepository;
	
	@RequestMapping("/createRecordsInsert")
	public List<Collectionzz> createRecordsInsert() {
		long prepstart = System.currentTimeMillis();
		List<Collectionzz> collectionzzs = prepareCollectionzzz();
		List<Collectionzz> insertedRecords;
		long prepfinish = System.currentTimeMillis();
		System.out.println("Total Preparation Time insert="+(prepfinish-prepstart)/1000);
		long start = System.currentTimeMillis();
		insertedRecords = collectionzzRepository.insert(collectionzzs);
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("Total time taken for insert="+timeElapsed/1000);
		return insertedRecords;
	}

	@RequestMapping("/createRecordsSave")
	public List<Collectionzz> createRecordsSave() {
		long prepstart = System.currentTimeMillis();
		List<Collectionzz> collectionzzs = prepareCollectionzzz();
		List<Collectionzz> insertedRecords;
		long prepfinish = System.currentTimeMillis();
		System.out.println("Total Preparation Time save="+(prepfinish-prepstart)/1000);
		long start = System.currentTimeMillis();
		insertedRecords = collectionzzRepository.save(collectionzzs);
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("Total time taken for save="+timeElapsed/1000);
		return insertedRecords;
	}
	
	@RequestMapping("/updateRecordsSave")
	public List<Collectionzz> updateRecordsSave() {
		long prepstart = System.currentTimeMillis();
		List<Collectionzz> collectionzzs = prepareCollectionzzz();
		List<Collectionzz> insertedRecords;
		long prepfinish = System.currentTimeMillis();
		System.out.println("Total Preparation Time save="+(prepfinish-prepstart)/1000);
		long start = System.currentTimeMillis();
		insertedRecords = collectionzzRepository.save(collectionzzs);
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("Total time taken for save="+timeElapsed/1000);
		return insertedRecords;
	}
	
	private List<Collectionzz> prepareCollectionzzz() {
		Collectionzz collectionzz = null;
		List<Collectionzz> collectionzzs = new ArrayList<Collectionzz>();
		for(int i=0;i<30000;i++) {
			collectionzz = new Collectionzz();
			collectionzz.setColumn1("column1"+i);
			collectionzz.setColumn2("column2"+i);
			collectionzz.setColumn3("column3"+i);
			collectionzz.setColumn4("column4"+i);
			collectionzz.setColumn5("column5"+i);
			collectionzz.setColumn6("column6"+i);
			collectionzz.setColumn7("column7"+i);
			collectionzz.setColumn8("column8"+i);
			collectionzz.setColumn9("column9"+i);
			collectionzz.setColumn10("column10"+i);
			collectionzz.setColumn11("column11"+i);
			collectionzz.setColumn12("column12"+i);
			collectionzz.setColumn13("column13"+i);
			collectionzz.setColumn14("column14"+i);
			collectionzz.setColumn15("column15"+i);
			collectionzz.setColumn16("column16"+i);
			collectionzz.setColumn17("column17"+i);
			collectionzz.setColumn18("column18"+i);
			collectionzz.setColumn19("column19"+i);
			collectionzz.setColumn20("column20"+i);
			collectionzz.setColumn21("column21"+i);
			collectionzz.setColumn22("column22"+i);
			collectionzz.setColumn23("column23"+i);
			collectionzz.setColumn24("column24"+i);
			collectionzz.setColumn25("column25"+i);
			collectionzz.setColumn26("column26"+i);
			collectionzz.setColumn28("column28"+i);
			collectionzz.setColumn29("column29"+i);
			collectionzz.setColumn30("column30"+i);
			collectionzz.setColumn31("column31"+i);
			collectionzz.setColumn32("column32"+i);
			collectionzz.setColumn33("column33"+i);
			collectionzz.setColumn34("column34"+i);
			collectionzz.setColumn35("column35"+i);
			collectionzz.setColumn36("column36"+i);
			collectionzz.setColumn37("column37"+i);
			collectionzz.setColumn38("column38"+i);
			collectionzz.setColumn39("column39"+i);
			collectionzz.setColumn40("column40"+i);
			collectionzzs.add(collectionzz);
		}
		return collectionzzs;
	}
}
