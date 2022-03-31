<script>
    import RangeSlider from "svelte-range-slider-pips";

    let message = "";
    let character;

    let selected = { id: 0, text: " " };

    let speedSliderValue;
    let speedSliderStats;
    let mightSliderValue;
    let mightSliderStats;
    let sanitySliderValue;
    let sanitySliderStats;
    let knowledgeSliderValue;
    let knowledgeSliderStats;

    let characters = [
        { id: 1, text: `Father Rhinehardt` },
        { id: 2, text: `Professor Longfellow` },
        { id: 3, text: `Peter Akimoto` },
        { id: 4, text: `Brandon Jaspers` },
        { id: 5, text: `Jenny LeClerc` },
        { id: 6, text: `Heather Granville` },
        { id: 7, text: `Vivian Lopez` },
        { id: 8, text: `Madame Zostra` },
        { id: 9, text: `Darrin "Flash" Williams` },
        { id: 10, text: `Ox Bellows` },
        { id: 11, text: `Zoe Ingstrom` },
        { id: 12, text: `Miss Dubourde` },
    ];

    async function updateCharacterInfo(e) {
        if (localStorage.getItem(selected.id)) {
            character = JSON.parse(localStorage.getItem(selected.id));
            speedSliderValue = character.speedIndex;
            speedSliderStats = [...character.speedStats];
            speedSliderStats.unshift("💀");
            mightSliderValue = character.mightIndex;
            mightSliderStats = [...character.mightStats];
            mightSliderStats.unshift("💀");
            sanitySliderValue = character.sanityIndex;
            sanitySliderStats = [...character.sanityStats];
            sanitySliderStats.unshift("💀");
            knowledgeSliderValue = character.knowledgeIndex;
            knowledgeSliderStats = [...character.knowledgeStats];
            knowledgeSliderStats.unshift("💀");
            message = "Saved character";
        } else {
            const response = await fetch(
                `http://localhost:8090/betrayal/api/character?id=${selected.id}`
            );

            if (response.ok) {
                const received = await response.json();
                character = received;
                speedSliderValue = character.defaultSpIndex;
                speedSliderStats = [...character.speedStats];
                speedSliderStats.unshift("💀");
                mightSliderValue = character.defaultMiIndex;
                mightSliderStats = [...character.mightStats];
                mightSliderStats.unshift("💀");
                sanitySliderValue = character.defaultSaIndex;
                sanitySliderStats = [...character.sanityStats];
                sanitySliderStats.unshift("💀");
                knowledgeSliderValue = character.defaultKnIndex;
                knowledgeSliderStats = [...character.knowledgeStats];
                knowledgeSliderStats.unshift("💀");
            }
        }
    }

    function showInfo() {
        alert("Maybe make a Modal for this?");
    }

    function handleReset() {
        handleRemove();
        updateCharacterInfo();
    }

    function handleRemove() {
        localStorage.removeItem(selected.id);
    }

    function handleSave() {
        var characterSave = {
            name: character.name,
            age: character.age,
            speedStats: character.speedStats,
            speedIndex: speedSliderValue,
            mightStats: character.mightStats,
            mightIndex: mightSliderValue,
            sanityStats: character.sanityStats,
            sanityIndex: sanitySliderValue,
            knowledgeStats: character.knowledgeStats,
            knowledgeIndex: knowledgeSliderValue,
        };
        localStorage.setItem(selected.id, JSON.stringify(characterSave));
    }
</script>

<header>
    <button class="helpBtn" on:click={showInfo}> ❓ Turn helper </button>
</header>

<main>
    <h1>Betrayal Stat Tracker</h1>
    <h2>Character</h2>
    <select
        class="charDropdown"
        bind:value={selected}
        on:change={(e) => updateCharacterInfo(e)}
    >
        {#each characters as selectedCharacter}
            <option value={selectedCharacter}>
                {selectedCharacter.text}
            </option>
        {/each}
    </select>

    {#if character}
        <div>
            <img
                src="character_images/{character.name}.png"
                alt={character.name}
            />
        </div>

        <p>Age {character.age}&nbsp&nbsp&nbsp&nbsp&nbsp {message}</p>
        <p />
        <button on:click={handleSave}> Save </button>
        <button on:click={handleRemove}> Remove saved</button>
        <button on:click={handleReset}> Default</button>

        <p class="statNames">Speed</p>
        <div id="speed-slider" class="speedSlider">
            <RangeSlider
                id="speed-slider"
                bind:values={speedSliderValue}
                formatter={(v) => speedSliderStats[v]}
                min={0}
                max={8}
                pips
                all="label"
            />
        </div>
        <!--<p class="currentStats">
            Current speed: {speedSliderStats[speedSliderValue]}
        </p>-->

        <p class="statNames">Might</p>
        <div class="mightSlider">
            <RangeSlider
                id="might-slider"
                bind:values={mightSliderValue}
                formatter={(v) => mightSliderStats[v]}
                min={0}
                max={8}
                pips
                all="label"
            />
        </div>
        <!--<p class="currentStats">
            current Might: {mightSliderStats[mightSliderValue]}
        </p>
        Default Might, nog kleuren: {character.defaultMiIndex}</p>-->

        <!--<p>{character.sanityStats}</p>-->
        <p class="statNames">Sanity</p>
        <div class="sanitySlider">
            <RangeSlider
                id="sanity-slider"
                bind:values={sanitySliderValue}
                formatter={(v) => sanitySliderStats[v]}
                min={0}
                max={8}
                pips
                all="label"
            />
        </div>
        <!--<p class="currentStats">
            current Sanity: {sanitySliderStats[sanitySliderValue]}
        </p>
        <p>Default Sanity, nog kleuren: {character.defaultSaIndex}</p>-->

        <!--<p>{character.knowledgeStats}</p>-->
        <p class="statNames">Knowledge</p>
        <div class="knowledgeSlider">
            <RangeSlider
                element
                id="knowledge-slider"
                bind:values={knowledgeSliderValue}
                formatter={(v) => knowledgeSliderStats[v]}
                min={0}
                max={8}
                pips
                all="label"
            />
        </div>
        <!--<p class="currentStats">
            current Knowledge: {knowledgeSliderStats[
                knowledgeSliderValue
            ]}
        </p>
        <p>Default Knowledge, nog kleuren: {character.defaultKnIndex}</p>-->
    {/if}
</main>

<style>
    .helpBtn {
        align-self: flex-start;
    }

    main {
        text-align: center;
        align-items: center;
        margin: 0 auto;
    }

    h1 {
        color: #912e2e;
        text-transform: uppercase;
        font-size: 3.8em;
        font-weight: 200;
    }

    h2 {
        text-transform: uppercase;
        font-weight: 150;
    }

    .charDropdown {
        text-align: center;
    }

    @media (min-width: 500px) {
        main {
            max-width: none;
        }
    }

    .statNames {
        font-size: 1.8rem;
        font-weight: 450;
    }

    .speedSlider {
        max-width: 70%;
        margin: 0 auto;
        --range-slider: #d7dada;
        --range-handle-inactive: #bb3030c2;
        --range-handle: #bb3030c2;
        --range-handle-focus: #bb3030;
    }

    .mightSlider {
        max-width: 70%;
        margin: 0 auto;
        --range-slider: #d7dada;
        --range-handle-inactive: rgba(255, 142, 132, 0.883);
        --range-handle: rgba(255, 142, 132, 0.883);
        --range-handle-focus: rgb(255, 142, 132);
    }

    .sanitySlider {
        max-width: 70%;
        margin: 0 auto;
        --range-slider: #d7dada;
        --range-handle-inactive: #4756e2be;
        --range-handle: #4756e2be;
        --range-handle-focus: #382be4;
    }

    .knowledgeSlider {
        max-width: 70%;
        margin: 0 auto;
        --range-slider: #d7dada;
        --range-handle-inactive: #7cf1bad8;
        --range-handle: #7cf1bad8;
        --range-handle-focus: #7cf1ba;
        padding-bottom: 1.5rem;
    }
</style>
