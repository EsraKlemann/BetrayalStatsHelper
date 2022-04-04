<script>
    import RangeSlider from "svelte-range-slider-pips";
    import Modal, { getModal } from "./Modal.svelte";

    let message = " ";
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
                message = "";
            }
        }
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

    let modalHeader = "How does a turn work?";
</script>

<header>
    <button class="explanationModal" on:click={() => getModal().open()}>
        ❓
    </button>
    <Modal>
        <h1>{modalHeader}</h1>
        <h4>
            We are all explorers of a haunted house. At some point during the
            game, the haunt begins, and one player will turn on the rest.
        </h4>
        <p>
            The game has 50 different scenarios. Neither the heroes nor the
            traitors will know how to win until the haunt starts and they read
            their separate secret scenario rules. Until the haunt begins,
            explore the house and try to find items that will help you survive.
        </p>
        <h3>On your turn</h3>
        <p>You may do as many of the following in any order:</p>
        <ul>
            <li>
                Move: <br />According to the “Speed” trait of your explorer.
                Movement ends if you enter a room that forces you to draw a
                card. Discover a new room, add new rooms as logically as
                possible, false features (e.g. a door leading to a wall) may
                occur, but you may not seal off a floor.
            </li>
            <li>Use item and omen cards</li>
        </ul>
        <p>Once during your turn an explorer may do each of the following:</p>
        <ul>
            <li>Trade an item</li>
            <li>Drop any number of items</li>
            <li>Pick up one or more items from an item pile</li>
            <li>
                For each item, you can only perform one of these actions per
                turn: Move, Use, Trade, Drop, Steal, pick up.
            </li>
        </ul>
        <h4>Attacking</h4>
        <p>
            Only happens after the haunt appears. Once during your turn, you may
            attack an opponent in the same room. Weapons can only be used when
            making an attack, not when defending. You may carry more than one
            weapon, but can only use one for an attack.<br />
            Both players roll dice equal to their Might Trait. The player with the
            lower number takes the difference in physical damage. The Haunt may allow
            you to make a haunt-specific action in addition to the attack. See page
            13 of rulebook for more rules and Special Attack Brief synopsis.
        </p>
    </Modal>
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
                class="charImages"
                src="./character_images/{character.name}.png"
                alt={character.name}
            />
        </div>
        <div>
            <p class="charInfo">
                Age {character.age}&nbsp&nbsp&nbsp&nbsp {message}
                <button on:click={handleSave}> Save </button>
                {#if message == "Saved character"}<button
                        on:click={handleRemove}
                    >
                        Remove saved</button
                    >{/if}
                <button on:click={handleReset}> Default</button>
            </p>
        </div>
        <hr />
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
    header {
        margin: 0;
    }

    .explanationModal {
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
        margin: 0;
    }

    h2 {
        text-transform: uppercase;
        font-weight: 150;
        margin: 0.5rem;
    }

    .charDropdown {
        text-align: center;
    }

    .charImages {
        max-width: 12rem;
    }

    .charInfo {
        margin: 0;
        margin-bottom: 0.5rem;
    }

    @media (min-width: 500px) {
        main {
            max-width: none;
        }
    }

    .statNames {
        font-size: 1.8rem;
        font-weight: 450;
        margin: 0;
    }

    .speedSlider {
        max-width: 70%;
        margin: 0 auto;
        padding-top: 0.5rem;
        padding-bottom: 0.4rem;
        --range-slider: #d7dada;
        --range-handle-inactive: #bb3030c2;
        --range-handle: #bb3030c2;
        --range-handle-focus: #bb3030;
    }

    .mightSlider {
        max-width: 70%;
        margin: 0 auto;
        padding-bottom: 0.4rem;
        --range-slider: #d7dada;
        --range-handle-inactive: rgba(255, 198, 132, 0.7);
        --range-handle: rgba(255, 198, 132, 0.7);
        --range-handle-focus: rgb(255, 198, 132);
    }

    .sanitySlider {
        max-width: 70%;
        margin: 0 auto;
        padding-bottom: 0.4rem;
        --range-slider: #d7dada;
        --range-handle-inactive: #7cf1bad8;
        --range-handle: #7cf1bad8;
        --range-handle-focus: #7cf1ba;
    }

    .knowledgeSlider {
        max-width: 70%;
        margin: 0 auto;
        --range-slider: #d7dada;
        --range-handle-inactive: #254fc3be;
        --range-handle: #254fc3be;
        --range-handle-focus: #1f46c8;
        padding-bottom: 1.4rem;
    }
</style>
