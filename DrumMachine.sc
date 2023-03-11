
DrumMachine {
	var kickPattern, tempoClock, synthGroup, scale, kickDrumMachineInstrument, snareDrumMachineInstrument, hatDrumMachineInstrument, crashDrumMachineInstrument;

	*new {
		|tempoClock, synthGroup, scale, kickSynth, kickVolBus, snareSynth, snareVolBus, hatSynth, hatVolBus, crashSynth, crashVolBus|
		^super.newCopyArgs(
			KickPattern.new,
			tempoClock,
			synthGroup,
			scale,
			DrumMachineInstrument(tempoClock, kickSynth, 1, scale, kickVolBus, synthGroup),
			DrumMachineInstrument(tempoClock, snareSynth, 1, scale, snareVolBus, synthGroup),
			DrumMachineInstrument(tempoClock, hatSynth, 0.2, scale, hatVolBus, synthGroup),
			DrumMachineInstrument(tempoClock, crashSynth, 2, scale, crashVolBus, synthGroup),
		);
	}

	randomKicks {
		kickDrumMachineInstrument.startBeat(kickPattern.random, [1]);
	}

	drumAndBass {
		kickDrumMachineInstrument.startBeat(kickPattern.get(3), [1]);
		snareDrumMachineInstrument.startBeat([1], [0, 1]);
		hatDrumMachineInstrument.startBeat([0.5], [1]);
		crashDrumMachineInstrument.startBeat([1,0.5,1], [0,1]);
	}

	hardcore {
		|kickNum|

		kickDrumMachineInstrument.startBeat(kickPattern.get(kickNum), [1]);
		snareDrumMachineInstrument.startBeat([1], [0, 1]);
		hatDrumMachineInstrument.startBeat([0.5], [1]);
		crashDrumMachineInstrument.startBeat([1,0.5,1], [0,1]);
	}

	kickPattern {
		|patternArray, instrumentArray|

		kickDrumMachineInstrument.startBeat(patternArray, instrumentArray);
	}

	snarePattern {
		|patternArray, instrumentArray|

		snareDrumMachineInstrument.startBeat(patternArray, instrumentArray);
	}

	hatPattern {
		|patternArray, instrumentArray|

		hatDrumMachineInstrument.startBeat(patternArray, instrumentArray);
	}

	crashPattern {
		|patternArray, instrumentArray|

		crashDrumMachineInstrument.startBeat(patternArray, instrumentArray);
	}

	stopKick {
		kickDrumMachineInstrument.stopBeat;
	}

	stopSnare {
		kickDrumMachineInstrument.stopBeat;
	}

	stopHat {
		kickDrumMachineInstrument.stopBeat;
	}

	stopCrash {
		crashDrumMachineInstrument.stopBeat;
	}

	stopAll {
		this.stopKick;
		this.stopSnare;
		this.stopHat;
		this.stopCrash;
	}
}