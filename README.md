# metacheck-core
This project contains a core library to validate metadata quality of Samply.MDR namespaces. 

## Usage

```sh
DataFetcher data = new DataFetcher(url, namespace, language, subjectID, accessToken);
MetricsCalculator calculator = MetricsCalculator.getCalculator();
Overview overview = calculator.evaluate(data);
List<Metric> metrics = overview.getMetrics();
List<Statistic> statistics = overview.getStatistics();
float score = overview.getNamespaceScore();

```

If you want to add more metrics, just implement either the interface IMetric for dataelements or INamespaceMetric for namespaces. Place them into the corresponding packages, since the calculator uses reflection to automatically load and apply all metrics found.  

## Citation
```
@conference {1111,
	title = {Evaluating Automated Methods for Metadata Quality in Healthcare},
	booktitle = {GMDS & CEN-IBS},
	year = {2020},
	address = {Berlin},
	author = {Alexandra Banach and Ann-Kristin Kock-Schoppenhauer and Hannes Ulrich and Josef Ingenerf}
}
```

## License
This source code is licensed under AGPL-3.0 License
