package name.milesparker.markets;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.amp.agf.IGraphicsAdapted;
import org.eclipse.amp.agf.IGraphicsAdapter;

import org.eclipse.swt.graphics.Color;
import org.eclipse.jface.viewers.IColorProvider;

import org.ascape.model.Agent;
import org.ascape.model.Cell;
import org.ascape.model.CellOccupant;
import org.ascape.model.HostCell;
import org.ascape.model.LocatedAgent;
import org.ascape.model.Scape;
import org.ascape.model.event.ScapeEvent;
import org.ascape.model.rule.Rule;
import org.ascape.model.rule.ExecuteThenUpdate;
import org.ascape.model.space.CollectionSpace;
import org.ascape.model.space.Coordinate;
import org.ascape.model.space.Coordinate2DDiscrete;
import org.ascape.model.space.Graph;
import org.ascape.model.space.Location;
import org.ascape.model.space.Singleton;
import org.ascape.runtime.NonGraphicRunner;
import org.ascape.util.Conditional;
import org.ascape.util.data.DataPoint;
import org.ascape.util.data.DataPointConcrete;
import org.ascape.util.vis.ColorFeature;
import org.ascape.util.vis.ColorFeatureConcrete;
import org.ascape.view.vis.ChartView;
import org.ascape.view.vis.GEFView;
import org.ascape.view.vis.GraphView;

import org.eclipse.amp.escape.runtime.extension.IAgentChild;

/**
 * <!-- begin-user-doc -->
 * Markets Java Implementation.
 * 
 * Generated by AMF for model: Markets.metaabm in project: org.eclipse.amp.amf.examples.escape 
 * <!-- end-user-doc -->
 * @generated
 */
public class Markets extends Scape implements IGraphicsAdapted {

	/**
	 * <!-- begin-user-doc -->
	 * The number of traders to create.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private int traderCount = 10;
	/**
	 * <!-- begin-user-doc -->
	 * The number of firms to create.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private int firmCount = 5;
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private double initialFirmValueMinimum = 100000;
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private double initialFirmValueMaximum = 1000000;
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private double earningMovementFactorMinimum = .99;
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private double earningMovementFactorMaximum = 1.01;
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private int firmSharesperInstrument = 1000;
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private double sharePriceAdjustmentMinimum = .98;
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private double sharePriceAdjustmentMaximum = 1.02;
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private double initialFirmPriceMinimum = 10.0;
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private double initialFirmPriceMaximum = 30.0;
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private double initialTraderFundsMinimum = 50000;
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private double initialTraderFundsMaximum = 50000;
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private int firmSharesCount = 10000;
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Scape instrumentHolders = null;
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Scape firmInstruments = null;
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Scape targetBuyFirms = null;

	private List<IAgentChild> children;

	public List<IAgentChild> getChildren() {
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Constructs a new Markets.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Markets() {

		children = new ArrayList<IAgentChild>();

	}

	//todo, make this a useful value for evaluating compatibility of different versions of generated classes

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final long serialVersionUID = 89989998L;

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static long nextUniqueID;

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private long uniqueID;

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getUID() {
		if (uniqueID == 0) {
			uniqueID = nextUniqueID++;
		}
		return uniqueID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Clones the agent, ensuring that a unique id is assigned.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object clone() {
		try {
			Markets clone = (Markets) super.clone();
			clone.uniqueID = 0;
			return clone;
		} catch (Exception e) {
			throw new RuntimeException("Unexpected cloning exception: " + e);
		}
	}

	org.ascape.model.Scape traderScape;
	org.ascape.model.Scape firmScape;
	org.ascape.model.Scape instrumentScape;

	/**
	 * <!-- begin-user-doc -->
	 * Create an instance of Trader that will be used to populate the traderScape.
	 * Overide to customize the prototype, for example to change the views created for a member scape.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Trader createTraderPrototype() {
		Trader trader = new Trader();
		return trader;
	}
	/**
	 * <!-- begin-user-doc -->
	 * Create an instance of Firm that will be used to populate the firmScape.
	 * Overide to customize the prototype, for example to change the views created for a member scape.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Firm createFirmPrototype() {
		Firm firm = new Firm();
		return firm;
	}
	/**
	 * <!-- begin-user-doc -->
	 * Create an instance of Instrument that will be used to populate the instrumentScape.
	 * Overide to customize the prototype, for example to change the views created for a member scape.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Instrument createInstrumentPrototype() {
		Instrument instrument = new Instrument();
		return instrument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	static int next_vm_id;

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	int vm_unique_id;

	/**
	 * <!-- begin-user-doc -->
	 * Creates the members of Markets.
	 * <!-- end-user-doc --> 
	 * @generated
	 */
	public void createScape() {
		super.createScape();

		setName("Markets");
		Trader traderProto = createTraderPrototype();
		traderScape = new Scape();
		traderScape.setName("Traders");
		traderScape.setPrototypeAgent(traderProto);
		traderScape.setExecutionOrder(Scape.RULE_ORDER);
		Firm firmProto = createFirmPrototype();
		firmScape = new Scape();
		firmScape.setName("Firms");
		firmScape.setPrototypeAgent(firmProto);
		firmScape.setExecutionOrder(Scape.RULE_ORDER);
		Instrument instrumentProto = createInstrumentPrototype();
		instrumentScape = new Scape();
		instrumentScape.setName("Instruments");
		instrumentScape.setPrototypeAgent(instrumentProto);
		instrumentScape.setExecutionOrder(Scape.RULE_ORDER);
		traderScape.setSize(getTraderCount());
		firmScape.setSize(getFirmCount());
		instrumentHolders = new Scape(new org.ascape.model.space.Graph());
		instrumentHolders.setName("InstrumentHolderss");
		add(instrumentHolders);
		firmInstruments = new Scape(new org.ascape.model.space.Graph());
		firmInstruments.setName("FirmInstrumentss");
		add(firmInstruments);
		targetBuyFirms = new Scape(new org.ascape.model.space.Graph());
		targetBuyFirms.setName("Target Buy Firmss");
		add(targetBuyFirms);

		add(traderScape);

		add(firmScape);

		add(instrumentScape);

		traderScape
				.addStatCollector(new org.ascape.util.data.StatCollectorCond(
						traderScape.getName() + " Population") {

					/**
					 * <!-- begin-user-doc -->
					 * 
					 * <!-- end-user-doc -->
					 * @generated
					 */
					private static final long serialVersionUID = 684614444640209893L;

					/**
					 * <!-- begin-user-doc -->
					 * 
					 * <!-- end-user-doc -->
					 * @generated
					 */
					@SuppressWarnings("unused")
					public final boolean meetsCondition(Object object) {
						return true;
					}
				});
		traderScape
				.addStatCollector(new org.ascape.util.data.StatCollectorCSAMM(
						"Trader Funds") {

					/**
					 * <!-- begin-user-doc -->
					 * 
					 * <!-- end-user-doc -->
					 * @generated
					 */
					private static final long serialVersionUID = 6846144446402098985L;

					/**
					 * <!-- begin-user-doc -->
					 * 
					 * <!-- end-user-doc -->
					 * @generated
					 */
					public final double getValue(Object trader) {
						return ((Trader) trader).getFunds();
					}
				});

		traderScape
				.addStatCollector(new org.ascape.util.data.StatCollectorCSAMM(
						"Trader Instrument Count") {

					/**
					 * <!-- begin-user-doc -->
					 * 
					 * <!-- end-user-doc -->
					 * @generated
					 */
					private static final long serialVersionUID = 6846144446402098985L;

					/**
					 * <!-- begin-user-doc -->
					 * 
					 * <!-- end-user-doc -->
					 * @generated
					 */
					public final double getValue(Object trader) {
						return ((Trader) trader).getInstrumentCount();
					}
				});

		firmScape.addStatCollector(new org.ascape.util.data.StatCollectorCond(
				firmScape.getName() + " Population") {

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			private static final long serialVersionUID = 684614444640209893L;

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@SuppressWarnings("unused")
			public final boolean meetsCondition(Object object) {
				return true;
			}
		});
		firmScape.addStatCollector(new org.ascape.util.data.StatCollectorCSAMM(
				"Firm Shares Outstanding") {

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			private static final long serialVersionUID = 6846144446402098985L;

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public final double getValue(Object firm) {
				return ((Firm) firm).getSharesOutstanding();
			}
		});

		firmScape.addStatCollector(new org.ascape.util.data.StatCollectorCSAMM(
				"Firm Last Earnings") {

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			private static final long serialVersionUID = 6846144446402098985L;

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public final double getValue(Object firm) {
				return ((Firm) firm).getLastEarnings();
			}
		});

		firmScape.addStatCollector(new org.ascape.util.data.StatCollectorCSAMM(
				"Firm Last Price") {

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			private static final long serialVersionUID = 6846144446402098985L;

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public final double getValue(Object firm) {
				return ((Firm) firm).getLastPrice();
			}
		});

		firmScape.addStatCollector(new org.ascape.util.data.StatCollectorCSAMM(
				"Firm Shares Internal") {

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			private static final long serialVersionUID = 6846144446402098985L;

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public final double getValue(Object firm) {
				return ((Firm) firm).getSharesInternal();
			}
		});

		instrumentScape
				.addStatCollector(new org.ascape.util.data.StatCollectorCond(
						instrumentScape.getName() + " Population") {

					/**
					 * <!-- begin-user-doc -->
					 * 
					 * <!-- end-user-doc -->
					 * @generated
					 */
					private static final long serialVersionUID = 684614444640209893L;

					/**
					 * <!-- begin-user-doc -->
					 * 
					 * <!-- end-user-doc -->
					 * @generated
					 */
					@SuppressWarnings("unused")
					public final boolean meetsCondition(Object object) {
						return true;
					}
				});
		instrumentScape
				.addStatCollector(new org.ascape.util.data.StatCollectorCond(
						"Instrument Ask Status") {

					/**
					 * <!-- begin-user-doc -->
					 * 
					 * <!-- end-user-doc -->
					 * @generated
					 */
					private static final long serialVersionUID = 6846144446402098985L;

					/**
					 * <!-- begin-user-doc -->
					 * 
					 * <!-- end-user-doc -->
					 * @generated
					 */
					public final boolean meetsCondition(Object instrument) {
						return StatusEnum.ask == ((Instrument) instrument)
								.getStatus();
					}
				});

		instrumentScape
				.addStatCollector(new org.ascape.util.data.StatCollectorCond(
						"Instrument Held Status") {

					/**
					 * <!-- begin-user-doc -->
					 * 
					 * <!-- end-user-doc -->
					 * @generated
					 */
					private static final long serialVersionUID = 6846144446402098985L;

					/**
					 * <!-- begin-user-doc -->
					 * 
					 * <!-- end-user-doc -->
					 * @generated
					 */
					public final boolean meetsCondition(Object instrument) {
						return StatusEnum.held == ((Instrument) instrument)
								.getStatus();
					}
				});

		instrumentScape
				.addStatCollector(new org.ascape.util.data.StatCollectorCond(
						"Instrument Bid Status") {

					/**
					 * <!-- begin-user-doc -->
					 * 
					 * <!-- end-user-doc -->
					 * @generated
					 */
					private static final long serialVersionUID = 6846144446402098985L;

					/**
					 * <!-- begin-user-doc -->
					 * 
					 * <!-- end-user-doc -->
					 * @generated
					 */
					public final boolean meetsCondition(Object instrument) {
						return StatusEnum.bid == ((Instrument) instrument)
								.getStatus();
					}
				});

		instrumentScape
				.addStatCollector(new org.ascape.util.data.StatCollectorCSAMM(
						"Instrument Offer Price") {

					/**
					 * <!-- begin-user-doc -->
					 * 
					 * <!-- end-user-doc -->
					 * @generated
					 */
					private static final long serialVersionUID = 6846144446402098985L;

					/**
					 * <!-- begin-user-doc -->
					 * 
					 * <!-- end-user-doc -->
					 * @generated
					 */
					public final double getValue(Object instrument) {
						return ((Instrument) instrument).getOfferPrice();
					}
				});

		instrumentScape
				.addStatCollector(new org.ascape.util.data.StatCollectorCSAMM(
						"Instrument Total Price") {

					/**
					 * <!-- begin-user-doc -->
					 * 
					 * <!-- end-user-doc -->
					 * @generated
					 */
					private static final long serialVersionUID = 6846144446402098985L;

					/**
					 * <!-- begin-user-doc -->
					 * 
					 * <!-- end-user-doc -->
					 * @generated
					 */
					public final double getValue(Object instrument) {
						return ((Instrument) instrument).getTotalPrice();
					}
				});

		traderScape.addInitialRule(new Rule("Initialize") {

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			private static final long serialVersionUID = 6846144446402098982L;

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public void execute(Agent a) {
				((name.milesparker.markets.Trader) a).intializeNonFramework();
			}
		});
		traderScape.addRule(new Rule("Ask") {

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			private static final long serialVersionUID = 6846144446402098981L;

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public void execute(Agent a) {
				((name.milesparker.markets.Trader) a).ask();
			}
		});
		traderScape.addRule(new Rule("Buy") {

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			private static final long serialVersionUID = 6846144446402098981L;

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public void execute(Agent a) {
				((name.milesparker.markets.Trader) a).buy();
			}
		});
		traderScape.addRule(new Rule("Execute") {

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			private static final long serialVersionUID = 6846144446402098981L;

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public void execute(Agent a) {
				((name.milesparker.markets.Trader) a).execute();
			}
		});

		firmScape.addInitialRule(new Rule("Initialize") {

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			private static final long serialVersionUID = 6846144446402098982L;

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public void execute(Agent a) {
				((name.milesparker.markets.Firm) a).intializeNonFramework();
			}
		});
		firmScape.addRule(new Rule("Modify Earnings") {

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			private static final long serialVersionUID = 6846144446402098981L;

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public void execute(Agent a) {
				((name.milesparker.markets.Firm) a).modifyEarnings();
			}
		});

		firmScape.addInitialRule(new Rule("Offer Shares") {

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			private static final long serialVersionUID = 6846144446402098982L;

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public void execute(Agent a) {
				((name.milesparker.markets.Firm) a).offerShares();
			}
		});
		firmScape.addRule(new Rule("Clear Offers") {

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			private static final long serialVersionUID = 6846144446402098981L;

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public void execute(Agent a) {
				((name.milesparker.markets.Firm) a).clearOffers();
			}
		});

	}

	/**
	 * <!-- begin-user-doc -->
	 * Creates UI views for Markets.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createGraphicViews() {
		super.createGraphicViews();
		createChartViews();

		createGraphViews();
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void scapeSetup(ScapeEvent scapeEvent) {
		//Set the size of the scape populations, e.g. for mutable scapes that need to have their size reset

		traderScape.setSize(getTraderCount());
		firmScape.setSize(getFirmCount());
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the Scape containing Traders.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.ascape.model.Scape getTraderScape() {
		return traderScape;
	}
	/**
	 * <!-- begin-user-doc -->
	 * Returns the Scape containing Firms.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.ascape.model.Scape getFirmScape() {
		return firmScape;
	}
	/**
	 * <!-- begin-user-doc -->
	 * Returns the Scape containing Instruments.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.ascape.model.Scape getInstrumentScape() {
		return instrumentScape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createChartViews() {
		ChartView chart = new ChartView();

		final Markets traderScape = new Markets();
		traderScape.setRunner(new NonGraphicRunner());
		Trader trader = new Trader() {

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public void requestUpdate() {
			}

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public Markets getMarkets() {
				return traderScape;
			}
		};
		traderScape.add(trader);
		HostCell traderHost = new HostCell() {

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public void requestUpdate() {
			}
		};
		traderHost.setOccupant((CellOccupant) trader);

		IColorProvider traderStyle2DColorProvider = new TraderStyle2DColorProvider();

		final Markets firmScape = new Markets();
		firmScape.setRunner(new NonGraphicRunner());
		Firm firm = new Firm() {

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public void requestUpdate() {
			}

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public Markets getMarkets() {
				return firmScape;
			}
		};
		firmScape.add(firm);
		HostCell firmHost = new HostCell() {

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public void requestUpdate() {
			}
		};
		firmHost.setOccupant((CellOccupant) firm);

		IColorProvider firmStyle2DColorProvider = new FirmStyle2DColorProvider();

		final Markets instrumentScape = new Markets();
		instrumentScape.setRunner(new NonGraphicRunner());
		Instrument instrument = new Instrument() {

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public void requestUpdate() {
			}

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public Markets getMarkets() {
				return instrumentScape;
			}
		};
		instrumentScape.add(instrument);
		HostCell instrumentHost = new HostCell() {

			/**
			 * <!-- begin-user-doc -->
			 * 
			 * <!-- end-user-doc -->
			 * @generated
			 */
			public void requestUpdate() {
			}
		};
		instrumentHost.setOccupant((CellOccupant) instrument);

		IColorProvider instrumentStyle2DColorProvider = new InstrumentStyle2DColorProvider();

		instrument.setStatus(StatusEnum.ask);
		chart.addSeries(
				"Count Instrument Ask Status",
				getInferredChartColor(instrument,
						instrumentStyle2DColorProvider));

		instrument.setStatus(StatusEnum.held);
		chart.addSeries(
				"Count Instrument Held Status",
				getInferredChartColor(instrument,
						instrumentStyle2DColorProvider));

		instrument.setStatus(StatusEnum.bid);
		chart.addSeries(
				"Count Instrument Bid Status",
				getInferredChartColor(instrument,
						instrumentStyle2DColorProvider));
		addView(chart);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void create2DViews() {
		addView(new GEFView());
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGraphViews() {
		instrumentHolders.addView(new GraphView());
		firmInstruments.addView(new GraphView());
		targetBuyFirms.addView(new GraphView());
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IGraphicsAdapter getGraphicsAdapter() {
		return MarketsGraphicsAdapter.getDefault();
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Color getInferredChartColor(Object agent,
			IColorProvider colorProvider) {
		Color color = colorProvider.getForeground(agent);
		if (color == ColorFeature.BLACK) {
			color = ColorFeatureConcrete.createHSB(
					(float) java.lang.Math.random() * 360f, 1.0f, 0.8f);
		}
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		(new NonGraphicRunner())
				.openInstance("name.milesparker.markets.Markets");
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public void startSimulationAgentChild(int timeStep) {
		if (timeStep == getRoot().getRunner().getEarliestPeriod()) {
			for (IAgentChild tmp : children) {
				tmp.startSimulation(timeStep);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public void calculateTimeStep(int timeStep) {
		for (IAgentChild tmp : children) {
			tmp.calculate(timeStep);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * Gets the Trader Count property for Markets.
	 * @return The number of traders to create.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTraderCount() {
		return traderCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Sets the Trader Count property for Markets.
	 * The number of traders to create.
	 * @param _traderCount the new Trader Count value
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraderCount(int _traderCount) {
		traderCount = _traderCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Gets the Firm Count property for Markets.
	 * @return The number of firms to create.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFirmCount() {
		return firmCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Sets the Firm Count property for Markets.
	 * The number of firms to create.
	 * @param _firmCount the new Firm Count value
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirmCount(int _firmCount) {
		firmCount = _firmCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Gets the Initial Firm Value Minimum property for Markets.
	 * @return 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInitialFirmValueMinimum() {
		return initialFirmValueMinimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Sets the Initial Firm Value Minimum property for Markets.
	 * 
	 * @param _initialFirmValueMinimum the new Initial Firm Value Minimum value
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialFirmValueMinimum(double _initialFirmValueMinimum) {
		initialFirmValueMinimum = _initialFirmValueMinimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Gets the Initial Firm Value Maximum property for Markets.
	 * @return 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInitialFirmValueMaximum() {
		return initialFirmValueMaximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Sets the Initial Firm Value Maximum property for Markets.
	 * 
	 * @param _initialFirmValueMaximum the new Initial Firm Value Maximum value
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialFirmValueMaximum(double _initialFirmValueMaximum) {
		initialFirmValueMaximum = _initialFirmValueMaximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Gets the Earning Movement Factor Minimum property for Markets.
	 * @return 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getEarningMovementFactorMinimum() {
		return earningMovementFactorMinimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Sets the Earning Movement Factor Minimum property for Markets.
	 * 
	 * @param _earningMovementFactorMinimum the new Earning Movement Factor Minimum value
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEarningMovementFactorMinimum(
			double _earningMovementFactorMinimum) {
		earningMovementFactorMinimum = _earningMovementFactorMinimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Gets the Earning Movement Factor Maximum property for Markets.
	 * @return 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getEarningMovementFactorMaximum() {
		return earningMovementFactorMaximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Sets the Earning Movement Factor Maximum property for Markets.
	 * 
	 * @param _earningMovementFactorMaximum the new Earning Movement Factor Maximum value
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEarningMovementFactorMaximum(
			double _earningMovementFactorMaximum) {
		earningMovementFactorMaximum = _earningMovementFactorMaximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Gets the Firm Shares per Instrument property for Markets.
	 * @return 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFirmSharesperInstrument() {
		return firmSharesperInstrument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Sets the Firm Shares per Instrument property for Markets.
	 * 
	 * @param _firmSharesperInstrument the new Firm Shares per Instrument value
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirmSharesperInstrument(int _firmSharesperInstrument) {
		firmSharesperInstrument = _firmSharesperInstrument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Gets the Share Price Adjustment Minimum property for Markets.
	 * @return 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSharePriceAdjustmentMinimum() {
		return sharePriceAdjustmentMinimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Sets the Share Price Adjustment Minimum property for Markets.
	 * 
	 * @param _sharePriceAdjustmentMinimum the new Share Price Adjustment Minimum value
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSharePriceAdjustmentMinimum(
			double _sharePriceAdjustmentMinimum) {
		sharePriceAdjustmentMinimum = _sharePriceAdjustmentMinimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Gets the Share Price Adjustment Maximum property for Markets.
	 * @return 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSharePriceAdjustmentMaximum() {
		return sharePriceAdjustmentMaximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Sets the Share Price Adjustment Maximum property for Markets.
	 * 
	 * @param _sharePriceAdjustmentMaximum the new Share Price Adjustment Maximum value
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSharePriceAdjustmentMaximum(
			double _sharePriceAdjustmentMaximum) {
		sharePriceAdjustmentMaximum = _sharePriceAdjustmentMaximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Gets the Initial Firm Price Minimum property for Markets.
	 * @return 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInitialFirmPriceMinimum() {
		return initialFirmPriceMinimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Sets the Initial Firm Price Minimum property for Markets.
	 * 
	 * @param _initialFirmPriceMinimum the new Initial Firm Price Minimum value
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialFirmPriceMinimum(double _initialFirmPriceMinimum) {
		initialFirmPriceMinimum = _initialFirmPriceMinimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Gets the Initial Firm Price Maximum property for Markets.
	 * @return 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInitialFirmPriceMaximum() {
		return initialFirmPriceMaximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Sets the Initial Firm Price Maximum property for Markets.
	 * 
	 * @param _initialFirmPriceMaximum the new Initial Firm Price Maximum value
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialFirmPriceMaximum(double _initialFirmPriceMaximum) {
		initialFirmPriceMaximum = _initialFirmPriceMaximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Gets the Initial Trader Funds Minimum property for Markets.
	 * @return 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInitialTraderFundsMinimum() {
		return initialTraderFundsMinimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Sets the Initial Trader Funds Minimum property for Markets.
	 * 
	 * @param _initialTraderFundsMinimum the new Initial Trader Funds Minimum value
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialTraderFundsMinimum(double _initialTraderFundsMinimum) {
		initialTraderFundsMinimum = _initialTraderFundsMinimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Gets the Initial Trader Funds Maximum property for Markets.
	 * @return 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInitialTraderFundsMaximum() {
		return initialTraderFundsMaximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Sets the Initial Trader Funds Maximum property for Markets.
	 * 
	 * @param _initialTraderFundsMaximum the new Initial Trader Funds Maximum value
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialTraderFundsMaximum(double _initialTraderFundsMaximum) {
		initialTraderFundsMaximum = _initialTraderFundsMaximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Gets the Firm Shares Count property for Markets.
	 * @return 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFirmSharesCount() {
		return firmSharesCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Sets the Firm Shares Count property for Markets.
	 * 
	 * @param _firmSharesCount the new Firm Shares Count value
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirmSharesCount(int _firmSharesCount) {
		firmSharesCount = _firmSharesCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Gets the InstrumentHolders property for Markets.
	 * @return 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scape getInstrumentHolders() {
		return instrumentHolders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Sets the InstrumentHolders property for Markets.
	 * 
	 * @param _instrumentHolders the new InstrumentHolders value
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstrumentHolders(Scape _instrumentHolders) {
		instrumentHolders = _instrumentHolders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Gets the FirmInstruments property for Markets.
	 * @return 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scape getFirmInstruments() {
		return firmInstruments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Sets the FirmInstruments property for Markets.
	 * 
	 * @param _firmInstruments the new FirmInstruments value
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirmInstruments(Scape _firmInstruments) {
		firmInstruments = _firmInstruments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Gets the Target Buy Firms property for Markets.
	 * @return 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scape getTargetBuyFirms() {
		return targetBuyFirms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Sets the Target Buy Firms property for Markets.
	 * 
	 * @param _targetBuyFirms the new Target Buy Firms value
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetBuyFirms(Scape _targetBuyFirms) {
		targetBuyFirms = _targetBuyFirms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		if (name == null) {
			return "Markets " + getUID();
		} else {
			return name;
		}
	}
}
